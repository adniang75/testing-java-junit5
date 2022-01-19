package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp () {
        controller = new IndexController();
    }

    @DisplayName( "Test Proper View name is returned for index page" )
    @Test
    void index () {
        assertEquals( "index", controller.index() );
        assertEquals( "index", controller.index(), "Wrong view returned from controller.index()" );
        assertEquals(
                "index", controller.index(),
                () -> "Another expensive message "
                        + "make me only if you have to"
        );
    }

    @Test
    @DisplayName( "Test exception" )
    void oupsHandler () {
        assertTrue(
                "notimplemented".equals( controller.oupsHandler() ),
                () -> "This is some expensive "
                        + "Message to build "
                        + "for my test"
        );
    }
}