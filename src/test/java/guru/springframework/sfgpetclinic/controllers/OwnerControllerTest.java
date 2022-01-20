package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

@SuppressWarnings( "unused" )
@ExtendWith( MockitoExtension.class )
class OwnerControllerTest {

    static final String OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    static final String REDIRECT_OWNERS_5 = "redirect:/owners/5";
    @Mock
    OwnerService ownerService;

    @Mock
    BindingResult result;

    @InjectMocks
    OwnerController controller;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void processFindFormWildcardString () {
        // given
        Owner owner = new Owner( 1L, "Jack", "Bauer" );
        List<Owner> ownerList = new ArrayList<>();
        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass( String.class );
        given( ownerService.findAllByLastNameLike( captor.capture() ) )
                .willReturn( ownerList );
        // when
        String returnedView = controller.processFindForm( owner, result, null );
        // then
        assertThat( captor.getValue() ).isEqualToIgnoringCase( "%Bauer%" );
    }

    @Test
    void processFindFormWildcardStringAnnotation () {
        // given
        Owner owner = new Owner( 1L, "Jack", "Bauer" );
        List<Owner> ownerList = new ArrayList<>();
        given( ownerService.findAllByLastNameLike( stringArgumentCaptor.capture() ) )
                .willReturn( ownerList );
        // when
        String returnedView = controller.processFindForm( owner, result, null );
        // then
        assertThat( stringArgumentCaptor.getValue() ).isEqualToIgnoringCase( "%Bauer%" );
    }

    @Test
    void processCreationFormWithErrors () {
        // given
        Owner owner = new Owner( 1L, "Jack", "Bauer" );
        given( result.hasErrors() ).willReturn( true );
        // when
        String returnedView = controller.processCreationForm( owner, result );
        // then
        then( ownerService ).should( never() ).save( owner );
        assertThat( returnedView ).isEqualTo( OWNERS_CREATE_OR_UPDATE_OWNER_FORM );
    }

    @Test
    void processCreationFormWithNoErrors () {
        // given
        Owner owner = new Owner( 5L, "Jack", "Bauer" );
        given( result.hasErrors() ).willReturn( false );
        given( ownerService.save( any() ) ).willReturn( owner );
        // when
        String returnedView = controller.processCreationForm( owner, result );
        // then
        then( ownerService ).should( times( 1 ) ).save( owner );
        assertThat( returnedView ).isEqualTo( REDIRECT_OWNERS_5 );
    }
}