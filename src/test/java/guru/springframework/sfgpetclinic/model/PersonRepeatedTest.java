package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.interfaces.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonRepeatedTest implements ModelRepeatedTests {

    @RepeatedTest( value = 10, name = "{displayName} {currentRepetition} of {totalRepetitions}" )
    @DisplayName( "Repeated Test" )
    void myRepeatedTest () {
        assertTrue( true );
    }

    @RepeatedTest( value = 5, name = "{displayName}" )
    @DisplayName( "Repeated Test With DI" )
    void myRepeatedTestWithDI () {
        assertTrue( true );
    }

    @RepeatedTest( value = 5, name = "{displayName}" )
    @DisplayName( "My Assignment Repeated Test" )
    void myAssignment () {
        assertTrue( true );
    }

}
