package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.junitextensions.TimingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith( TimingExtension.class )
class PetSDJpaServiceIT {

    @BeforeEach
    void setUp () {
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