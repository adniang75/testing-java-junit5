package guru.springframework.mockito;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class InlineMockTest {

    @Test
    @SuppressWarnings( { "unchecked", "rawtypes" } )
    void testInlineMock () {
        Map mapMock = mock( Map.class );
        assertThat( mapMock ).isNotNull();
    }
}
