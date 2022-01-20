package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith( MockitoExtension.class )
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName( "Test Find All" )
    @Test
    void findAll () {
        Set<Visit> visits = new HashSet<>( Arrays.asList(
                new Visit( 1L, LocalDate.now() ),
                new Visit( 2L, LocalDate.now() ),
                new Visit( 3L, LocalDate.now() ),
                new Visit( 4L, LocalDate.now() ),
                new Visit( 5L, LocalDate.now() )
        ) );
        when( visitRepository.findAll() ).thenReturn( visits );
        Set<Visit> foundVisits = service.findAll();
        assertThat( foundVisits ).isNotNull();
        assertThat( foundVisits ).hasSize( 5 );
        verify( visitRepository ).findAll();
    }

    @DisplayName( "Test Find By ID" )
    @Test
    void findById () {
        Visit visit = new Visit( 1L, LocalDate.now() );
        when( visitRepository.findById( anyLong() ) ).thenReturn( Optional.of( visit ) );
        Visit foundVisit = service.findById( 1L );
        assertThat( foundVisit ).isNotNull();
        assertThat( foundVisit.getId() ).isEqualTo( 1L );
        verify( visitRepository ).findById( anyLong() );
    }

    @DisplayName( "Test Save" )
    @Test
    void save () {
        Visit visit = new Visit( 1L, LocalDate.now() );
        when( visitRepository.save( any( Visit.class ) ) ).thenReturn( visit );
        Visit savedVisit = service.save( visit );
        assertThat( savedVisit ).isNotNull();
        assertThat( savedVisit.getId() ).isEqualTo( 1L );
        verify( visitRepository ).save( any( Visit.class ) );
    }

    @DisplayName( "Test Delete" )
    @Test
    void delete () {
        Visit visit = new Visit( 1L, LocalDate.now() );
        service.delete( visit );
        verify( visitRepository ).delete( any( Visit.class ) );
    }

    @DisplayName( "Test Delete By ID" )
    @Test
    void deleteById () {
        service.deleteById( anyLong() );
        verify( visitRepository ).deleteById( anyLong() );
    }
}