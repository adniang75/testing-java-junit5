package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest {

    private SpecialtyService specialtyService;
    private VetService vetService;
    private VetController controller;

    @BeforeEach
    void setUp () {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService( specialtyService );
        controller = new VetController( vetService );
        Vet vet1 = new Vet( 1L, "joe", "buck", null );
        Vet vet2 = new Vet( 2L, "jimmy", "smith", null );
        vetService.save( vet1 );
        vetService.save( vet2 );
    }

    @Test
    void listVets () {
        Model model = new ModelMapImpl();

        String view = controller.listVets( model );
        assertThat( view )
                .withFailMessage( "Expected view name to be vets/index" )
                .isEqualTo( "vets/index" );

        Set modelAttribute = (Set) ( (ModelMapImpl) model ).getModel().get( "vets" );
        assertThat( modelAttribute.size() )
                .isEqualTo( 2 );
    }
}