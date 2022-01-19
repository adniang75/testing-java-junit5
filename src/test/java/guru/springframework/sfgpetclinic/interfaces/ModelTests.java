package guru.springframework.sfgpetclinic.interfaces;

import org.junit.jupiter.api.*;

@Tag( "model" )
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public interface ModelTests {

    @BeforeAll
    default void beforeAllConsoleOutput ( TestInfo testInfo ) {
        System.out.println( testInfo.getDisplayName() );
    }

    @BeforeEach
    default void beforeEachConsoleOutput ( TestInfo testInfo ) {
        System.out.printf( "\tRunning Test - %s%n",
                testInfo.getDisplayName() );
    }

}
