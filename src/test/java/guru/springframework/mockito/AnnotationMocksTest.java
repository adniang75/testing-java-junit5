package guru.springframework.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings( { "unchecked", "rawtypes", "deprecation" } )
class AnnotationMocksTest {

    @Mock
    Map mapMock;

    @BeforeEach
    void setUp () {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    void testMock () {
        mapMock.put( "key", "value" );
        assertThat( mapMock ).isNotNull();
    }
}
