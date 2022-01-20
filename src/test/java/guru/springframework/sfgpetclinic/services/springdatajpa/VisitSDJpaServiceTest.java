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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@ExtendWith( MockitoExtension.class )
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName( "Test Find All" )
    @Test
    void findAll () {
        // given
        Set<Visit> visits = new HashSet<>( Arrays.asList(
                new Visit( 1L, LocalDate.now() ),
                new Visit( 2L, LocalDate.now() ),
                new Visit( 3L, LocalDate.now() ),
                new Visit( 4L, LocalDate.now() ),
                new Visit( 5L, LocalDate.now() )
        ) );
        given( visitRepository.findAll() ).willReturn( visits );
        // when
        Set<Visit> foundVisits = service.findAll();
        // then
        then( visitRepository ).should().findAll();
        assertThat( foundVisits ).isNotNull();
        assertThat( foundVisits ).hasSize( 5 );
    }

    @DisplayName( "Test Find By ID" )
    @Test
    void findById () {
        // given
        Visit visit = new Visit( 1L, LocalDate.now() );
        given( visitRepository.findById( anyLong() ) ).willReturn( Optional.of( visit ) );
        // when
        Visit foundVisit = service.findById( 1L );
        // then
        then( visitRepository ).should().findById( anyLong() );
        assertThat( foundVisit ).isNotNull();
        assertThat( foundVisit.getId() ).isEqualTo( 1L );
    }

    @DisplayName( "Test Save" )
    @Test
    void save () {
        // given
        Visit visit = new Visit( 1L, LocalDate.now() );
        given( visitRepository.save( any( Visit.class ) ) ).willReturn( visit );
        // when
        Visit savedVisit = service.save( visit );
        // then
        then( visitRepository ).should().save( any( Visit.class ) );
        assertThat( savedVisit ).isNotNull();
        assertThat( savedVisit.getId() ).isEqualTo( 1L );
    }

    @DisplayName( "Test Delete" )
    @Test
    void delete () {
        // given
        Visit visit = new Visit( 1L, LocalDate.now() );
        // when
        service.delete( visit );
        // then
        then( visitRepository ).should().delete( any( Visit.class ) );
    }

    @DisplayName( "Test Delete By ID" )
    @Test
    void deleteById () {
        // given - none
        // when
        service.deleteById( anyLong() );
        // then
        then( visitRepository ).should().deleteById( anyLong() );
    }
}