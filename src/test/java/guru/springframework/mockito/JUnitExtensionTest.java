package guru.springframework.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith( MockitoExtension.class )
class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock () {
        mapMock.put( "key", "value" );
    }
}
