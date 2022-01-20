package guru.springframework.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp () {
        MockitoAnnotations.initMocks( this );
    }

    @Test
    void testMock () {
        mapMock.put( "key", "value" );
        assertThat( mapMock ).containsEntry( "key", "value" );
    }
}
