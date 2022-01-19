package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
}