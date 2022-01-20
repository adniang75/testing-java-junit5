package guru.springframework.sfgpetclinic.controllers;

public class IndexController {

    private static final String INDEX = "index";
    private static final String NOT_IMPLEMENTED = "notImplemented";

    public String index () {
        return INDEX;
    }

    public String oupsHandler () {
        return NOT_IMPLEMENTED;
    }

    public String oopsException () {
        throw new ValueNotFoundException();
    }

}
