package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.interfaces.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class PersonRepeatedTest implements ModelRepeatedTests {

    @RepeatedTest( value = 10, name = "{displayName} {currentRepetition} of {totalRepetitions}" )
    @DisplayName( "Repeated Test" )
    void myRepeatedTest () {
        // TODO - impl
    }

    @RepeatedTest( value = 5, name = "{displayName}" )
    @DisplayName( "Repeated Test With DI" )
    void myRepeatedTestWithDI ( TestInfo testInfo, RepetitionInfo repetitionInfo ) {
        //System.out.println( testInfo.getDisplayName() + " => " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions() );
    }

    @RepeatedTest( value = 5, name = "{displayName}" )
    @DisplayName( "My Assignment Repeated Test" )
    void myAssignment () {
        // TODO - impl
    }

}
