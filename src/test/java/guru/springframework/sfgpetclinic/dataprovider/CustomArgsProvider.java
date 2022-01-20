package guru.springframework.sfgpetclinic.dataprovider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments ( ExtensionContext context ) {
        return Stream.of(
                Arguments.of( "FL", 1, 1 ),
                Arguments.of( "NY", 2, 2 ),
                Arguments.of( "NJ", 3, 3 ) );
    }
}
