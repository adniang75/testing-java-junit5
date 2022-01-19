package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Owner Map Service Test - " )
class OwnerMapServiceTest {

    PetTypeService petTypeService;
    PetService petService;
    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp () {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService( petTypeService, petService );
        System.out.println( "First BeforeEach" );
    }

    @Test
    @DisplayName( "Verify Zero Owners" )
    void ownersAreZero () {
        int ownerCount = ownerMapService.findAll().size();
        assertThat( ownerCount ).isZero();
    }

    @Test
    @DisplayName( "Verify Still Zero Owners" )
    void ownersAreStillZero () {
        int ownerCount = ownerMapService.findAll().size();
        assertThat( ownerCount ).isZero();
    }

    @Nested
    @DisplayName( "Pet Type - " )
    class CreatePetTypesTests {

        @BeforeEach
        void setUp () {
            PetType dog = new PetType( 1L, "Dog" );
            PetType cat = new PetType( 2L, "Cat" );
            petTypeService.save( dog );
            petTypeService.save( cat );
            System.out.println( "Nested BeforeEach" );
        }

        @Test
        @DisplayName( "Verify Two Pet Types" )
        void testPetCount () {
            int petTypeCount = petTypeService.findAll().size();
            assertThat( petTypeCount ).isEqualTo( 2 );
        }

        @Nested
        @DisplayName( "Save Owners Tests -" )
        class SaveOwnersTests {

            @BeforeEach
            void setUp () {
                ownerMapService.save( new Owner( 1L, "Before", "Each" ) );
                System.out.println( "Saved Owners Before Each" );
            }

            @Test
            void saveOwner () {
                Owner owner = new Owner( 2L, "Joe", "Buck" );
                Owner savedOwner = ownerMapService.save( owner );
                assertThat( savedOwner ).isNotNull();
            }

            @Nested
            @DisplayName( "Save Owners Tests -" )
            class FindOwnersTests {

                @Test
                @DisplayName( "Find Owner" )
                void findOwner () {
                    Owner foundOwner = ownerMapService.findById( 1L );
                    assertThat( foundOwner ).isNotNull();
                }

                @Test
                void findOwnerNotFound () {
                    Owner foundOwner = ownerMapService.findById( 2L );
                    assertThat( foundOwner ).isNull();
                }
            }
        }
    }


}