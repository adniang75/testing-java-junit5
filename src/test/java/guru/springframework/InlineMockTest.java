package guru.springframework;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class InlineMockTest {

    @Test
    void testInlineMock () {
        Map mapMock = mock( Map.class );
        assertThat( mapMock.size() ).isEqualTo( 0 );
    }
}
