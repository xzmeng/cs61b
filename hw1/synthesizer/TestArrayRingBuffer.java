package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        assertEquals(0, arb.fillCount());
        assertEquals(3, arb.capacity());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(3, (int) arb.fillCount());

        assertEquals(1, (int) arb.dequeue());
        assertEquals(2, (int) arb.dequeue());
        assertEquals(3, (int) arb.dequeue());
        assertEquals(0, (int) arb.fillCount());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
