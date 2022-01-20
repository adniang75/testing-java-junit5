package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

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