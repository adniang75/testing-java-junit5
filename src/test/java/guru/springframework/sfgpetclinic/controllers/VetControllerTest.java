package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.interfaces.ControllerTests;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTests {

    private VetController controller;

    @BeforeEach
    void setUp () {
        SpecialtyService specialtyService = new SpecialityMapService();
        VetService vetService = new VetMapService( specialtyService );
        controller = new VetController( vetService );
        Vet vet1 = new Vet( 1L, "joe", "buck", null );
        Vet vet2 = new Vet( 2L, "jimmy", "smith", null );
        vetService.save( vet1 );
        vetService.save( vet2 );
    }

    @Test
    void listVets () {
        ModelMapImpl model = new ModelMapImpl();

        String view = controller.listVets( model );
        assertThat( view )
                .withFailMessage( "Expected view name to be vets/index" )
                .isEqualTo( "vets/index" );

        Set modelAttribute = (Set) model.getModel().get( "vets" );
        assertThat( modelAttribute.size() )
                .isEqualTo( 2 );
    }
}