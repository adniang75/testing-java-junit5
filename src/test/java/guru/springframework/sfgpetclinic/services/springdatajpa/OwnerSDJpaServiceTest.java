package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled( value = "Disabled until we learn Mocking" )
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    void setUp () {
        service = new OwnerSDJpaService( null, null, null );
    }

    @Disabled( value = "Disabled until we learn Mocking" )
    @Test
    void findByLastName () {
        Owner foundOwner = service.findByLastName( "Buck" );
        assertEquals( "Buck", foundOwner.getLastName() );
    }

    @Test
    void findAllByLastNameLike () {
        assertTrue( true );
    }

    @Test
    void findAll () {
        assertTrue( true );
    }

    @Test
    void findById () {
        assertTrue( true );
    }

    @Test
    void save () {
        assertTrue( true );
    }

    @Test
    void delete () {
        assertTrue( true );
    }

    @Test
    void deleteById () {
        assertTrue( true );
    }
}