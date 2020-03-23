import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        for (int i = 0; i < 500; i += 1) {
            assertTrue(Flik.isSameNumber(i, i));
        }
    }
}