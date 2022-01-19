package guru.springframework.sfgpetclinic.interfaces;


import org.junit.jupiter.api.*;

@Tag( "repeated" )
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public interface ModelRepeatedTests {

    @BeforeAll
    default void beforeAllConsoleOutput ( TestInfo testInfo ) {
        System.out.println( testInfo.getDisplayName() );
    }

    @BeforeEach
    default void beforeEachConsoleOutput ( TestInfo testInfo, RepetitionInfo repetitionInfo ) {
        System.out.printf( "\tRunning Test - %s - %d | %d%n",
                testInfo.getDisplayName(),
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions() );
    }

}
