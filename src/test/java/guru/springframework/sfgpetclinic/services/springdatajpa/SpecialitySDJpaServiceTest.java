package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

@ExtendWith( MockitoExtension.class )
class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void testDeleteByObject () {
        // given
        Speciality speciality = new Speciality();
        // when
        service.delete( speciality );
        then( specialtyRepository ).should().delete( any( Speciality.class ) );
    }

    @Test
    void findByIdBddTest () {
        // given
        Speciality speciality = new Speciality();
        given( specialtyRepository.findById( anyLong() ) )
                .willReturn( Optional.of( speciality ) );
        // when
        Speciality foundSpecialty = service.findById( 1L );
        // then
        assertThat( foundSpecialty ).isNotNull();
        verify( specialtyRepository ).findById( anyLong() );
        then( specialtyRepository ).should().findById( anyLong() );
        then( specialtyRepository ).should( times( 1 ) ).findById( anyLong() );
        then( specialtyRepository ).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteById () {
        // given - none
        // when
        service.deleteById( 1L );
        // then
        then( specialtyRepository ).should( times( 1 ) ).deleteById( anyLong() );
    }

    @Test
    void deleteByIdAtLeast () {
        // given - none
        // when
        service.deleteById( 1L );
        service.deleteById( 1L );
        // then
        then( specialtyRepository ).should( atLeast( 1 ) ).deleteById( anyLong() );
    }

    @Test
    void deleteByIdAtMost () {
        // given - none
        // when
        service.deleteById( 1L );
        service.deleteById( 1L );
        // then
        then( specialtyRepository ).should( atMost( 5 ) ).deleteById( anyLong() );
    }

    @Test
    void deleteByIdNever () {
        // given - none
        // when
        service.deleteById( 1L );
        service.deleteById( 1L );
        // then
        then( specialtyRepository ).should( atLeast( 1 ) ).deleteById( anyLong() );
        then( specialtyRepository ).should( atMost( 5 ) ).deleteById( anyLong() );
        then( specialtyRepository ).should( never() ).deleteById( 5L );
    }

    @Test
    void testDelete () {
        // given - none
        // when
        service.delete( new Speciality() );
        // then
        then( specialtyRepository ).should().delete( any( Speciality.class ) );
    }

    @Test
    void testDoThrow () {
        doThrow( new RuntimeException( "boom" ) ).when( specialtyRepository ).delete( any() );
        assertThrows( RuntimeException.class, () -> specialtyRepository.delete( new Speciality() ) );
        verify( specialtyRepository ).delete( any() );
    }

    @Test
    void testFindByIdThrows () {
        given( specialtyRepository.findById( anyLong() ) ).willThrow( new RuntimeException( "boom" ) );
        assertThrows( RuntimeException.class, () -> service.findById( anyLong() ) );
        then( specialtyRepository ).should().findById( anyLong() );
    }

    @Test
    void testDeleteBDD () {
        willThrow( new RuntimeException( "boom" ) ).given( specialtyRepository ).delete( any() );
        assertThrows( RuntimeException.class, () -> specialtyRepository.delete( any() ) );
        then( specialtyRepository ).should().delete( any() );
    }
}