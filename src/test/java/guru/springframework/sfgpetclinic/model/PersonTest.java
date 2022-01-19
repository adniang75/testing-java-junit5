package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void groupedAssertions () {
        // given
        Person person = new Person( 1l, "Joe", "Buck" );
        //then
        assertAll(
                "Test Properties Set",
                () -> assertEquals( "Joe", person.getFirstName() ),
                () -> assertEquals( "Buck", person.getLastName() )
        );
    }

    @Test
    void groupedAssertionsWithMessages () {
        // given
        Person person = new Person( 1l, "Joe", "Buck" );
        //then
        assertAll(
                "Test Properties Set With Messages",
                () -> assertEquals( "Joe", person.getFirstName(), "First Name is not correct" ),
                () -> assertEquals( "Buck", person.getLastName(), "Last Name is not correct" )
        );
    }
}