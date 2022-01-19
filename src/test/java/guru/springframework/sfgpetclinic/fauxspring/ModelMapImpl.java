package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

    Map<String, Object> model = new HashMap<>();

    @Override
    public void addAttribute ( String key, Object o ) {
        model.put( key, o );
    }

    @Override
    public void addAttribute ( Object o ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, Object> getModel () {
        return model;
    }
}
