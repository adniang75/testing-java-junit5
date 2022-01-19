package guru.springframework.sfgpetclinic.interfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance( TestInstance.Lifecycle.PER_CLASS )
@Tag( "controller" )
public interface ControllerTests {

    @BeforeAll
    default void beforeAll () {
        System.out.println( "Let's do something here" );
    }

}
