import org.junit.Test;
import static org.junit.Assert.*;
public class TestLinkedListDeque {

    @Test
    public void testAddFirstRemoveFirst() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();

        assertEquals(lld.size(), 0);
        assertTrue(lld.isEmpty());

        lld.addFirst(1);
        lld.addFirst(2);
        lld.addFirst(3);

        assertEquals(lld.size(), 3);
        assertFalse(lld.isEmpty());

        int i;
        i = lld.removeFirst();
        assertEquals(i, 3);
        i = lld.removeFirst();
        assertEquals(i, 2);
        i = lld.removeFirst();
        assertEquals(i, 1);

        assertEquals(lld.size(), 0);
        assertTrue(lld.isEmpty());

        // remove from empty lld
        assertNull(lld.removeFirst());
    }
    
    @Test
    public void testAddLastRemoveLast() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();

        assertEquals(lld.size(), 0);
        assertTrue(lld.isEmpty());

        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);

        assertEquals(lld.size(), 3);
        assertFalse(lld.isEmpty());

        int i;
        i = lld.removeLast();
        assertEquals(i, 3);
        i = lld.removeLast();
        assertEquals(i, 2);
        i = lld.removeLast();
        assertEquals(i, 1);

        assertEquals(lld.size(), 0);
        assertTrue(lld.isEmpty());

        // remove from empty lld
        assertNull(lld.removeLast());
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);

        assertEquals((int) lld.get(0), 1);
        assertEquals((int) lld.get(0), 1);
        assertEquals((int) lld.get(0), 1);
    }

    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);

        assertEquals((int) lld.get(0), 1);
        assertEquals((int) lld.get(0), 1);
        assertEquals((int) lld.get(0), 1);
    }

    @Test
    public void testPrintDeque() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        System.out.println("----testPrintDeque() start----");
        lld.printDeque();
        System.out.println("should be \"1, 2, 3\"");
        System.out.println("----testPrintDeque() end----");
    }
}
