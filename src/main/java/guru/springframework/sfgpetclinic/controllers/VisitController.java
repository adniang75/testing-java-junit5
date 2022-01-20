package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.WebDataBinder;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;

import javax.validation.Valid;
import java.util.Map;


public class VisitController {

    private static final String VIEW_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";

    private final VisitService visitService;
    private final PetService petService;

    public VisitController ( VisitService visitService, PetService petService ) {
        this.visitService = visitService;
        this.petService = petService;
    }

    public void setAllowedFields ( WebDataBinder dataBinder ) {
        dataBinder.setDisallowedFields( "id" );
    }

    public Visit loadPetWithVisit ( Long petId, Map<String, Object> model ) {
        Pet pet = petService.findById( petId );
        model.put( "pet", pet );
        Visit visit = new Visit();
        pet.getVisits().add( visit );
        visit.setPet( pet );
        return visit;
    }

    public String initNewVisitForm ( Long petId, Map<String, Object> model ) {
        return VIEW_CREATE_OR_UPDATE_VISIT_FORM;
    }

    public String processNewVisitForm ( @Valid Visit visit, BindingResult result ) {
        if ( result.hasErrors() ) {
            return VIEW_CREATE_OR_UPDATE_VISIT_FORM;
        } else {
            visitService.save( visit );

            return "redirect:/owners/{ownerId}";
        }
    }
}
