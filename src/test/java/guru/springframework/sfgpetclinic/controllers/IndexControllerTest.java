package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.interfaces.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.condition.JRE.JAVA_11;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

//@Tag( "controller" )
class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp () {
        controller = new IndexController();
    }

    @DisplayName( "Test Proper View name is returned for index page" )
    @Test
    void index () {
        assertEquals( "index", controller.index() );
        assertEquals( "index", controller.index(), "Wrong view returned from controller.index()" );
        assertEquals(
                "index", controller.index(),
                () -> "Another expensive message "
                        + "make me only if you have to"
        );
    }

    @Test
    @DisplayName( "Test exception handler" )
    void oupsHandler () {
        assertTrue(
                "notimplemented".equals( controller.oupsHandler() ),
                () -> "This is some expensive "
                        + "Message to build "
                        + "for my test"
        );
    }

    @Test
    @DisplayName( "Test Thrown Exception" )
    void oopsException () {
        assertThrows(
                ValueNotFoundException.class,
                () -> controller.oopsException()
        );
    }

    @Disabled( "Demo of timeout" )
    @Test
    void testTimeout () {
        assertTimeout(
                Duration.ofMillis( 100 ),
                () -> {
                    Thread.sleep( 2000 );
                    System.out.println( "I got here" );
                }
        );
    }

    @Disabled( "Demo of timeout preemptively" )
    @Test
    void testTimeoutPreemptively () {
        assertTimeoutPreemptively(
                Duration.ofMillis( 100 ),
                () -> {
                    Thread.sleep( 2000 );
                    System.out.println( "I got here preemptively" );
                }
        );
    }

    @Test
    void testAssumptionTrue () {
        assumeTrue( "GURU".equalsIgnoreCase( System.getenv( "GURU_RUNTILE" ) ) );
    }

    @Test
    void testAssumptionTrueHome () {
        assumeTrue( "/Users/alassaneniang".equalsIgnoreCase( System.getenv( "HOME" ) ) );
    }

    @Nested
    class ConditionalTests {

        @EnabledOnOs( OS.MAC )
        @Test
        void testOnMacOS () {

        }

        @EnabledOnOs( OS.WINDOWS )
        @Test
        void testOnWindows () {

        }

        @EnabledOnJre( JAVA_8 )
        @Test
        void testOnJava8 () {

        }

        @EnabledOnJre( JAVA_11 )
        @Test
        void testOnJava11 () {

        }

        @EnabledIfEnvironmentVariable( named = "USER", matches = "alassaneniang" )
        @Test
        void testIfUserIsMe () {

        }

        @EnabledIfEnvironmentVariable( named = "USER", matches = "jt" )
        @Test
        void testIfUserIsJT () {

        }
    }

    @Nested
    class UsingAssertJWithJUnit5Test {

        @Test
        void index () {
            assertThat( controller.index() )
                    .withFailMessage( () -> "Wrong view returned from controller.index()" )
                    .isEqualTo( "index" );
        }
    }

}