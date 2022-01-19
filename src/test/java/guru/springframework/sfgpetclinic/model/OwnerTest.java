package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest {

    Owner owner;

    @BeforeEach
    void setUp () {
        owner = new Owner( 1L, "Joe", "Buck" );
        owner.setCity( "Key West" );
        owner.setTelephone( "1231231234" );
    }

    @Test
    void dependentAssertions () {

        assertAll(
                "Properties Test",
                () -> assertAll(
                        "Person Properties",
                        () -> assertEquals( "Joe", owner.getFirstName(), "First name not set properly" ),
                        () -> assertEquals( "Buck", owner.getLastName(), "Last name not set properly" )
                ),
                () -> assertAll(
                        "Owner Properties",
                        () -> assertEquals( "Key West", owner.getCity(), "City not set properly" ),
                        () -> assertEquals( "1231231234", owner.getTelephone(), "Telephone not set properly" )
                )
        );

    }

    @Nested
    class UsingHamcrestWithJUnit5Test {

        @Test
        void index () {

            assertThat( owner.getCity(), is( equalTo( "Key West" ) ) );

        }
    }

}