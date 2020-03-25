import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque {
    @Test
    public void testAddFirstGet() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);

        assertEquals((int) ad.get(0), 3);
        assertEquals((int) ad.get(1), 2);
        assertEquals((int) ad.get(2), 1);
    }

    @Test
    public void testAddFirstRemoveFirst() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertEquals(ad.size(), 0);
        assertTrue(ad.isEmpty());

        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);

        assertEquals(ad.size(), 3);
        assertFalse(ad.isEmpty());

        int i;
        i = ad.removeFirst();
        assertEquals(i, 3);
        i = ad.removeFirst();
        assertEquals(i, 2);
        i = ad.removeFirst();
        assertEquals(i, 1);

        assertEquals(ad.size(), 0);
        assertTrue(ad.isEmpty());

        // remove from empty ad
        assertNull(ad.removeFirst());
    }

    @Test
    public void testAddLastRemoveLast() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        assertEquals(ad.size(), 0);
        assertTrue(ad.isEmpty());

        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);

        assertEquals(ad.size(), 3);
        assertFalse(ad.isEmpty());

        int i;
        i = ad.removeLast();
        assertEquals(i, 3);
        i = ad.removeLast();
        assertEquals(i, 2);
        i = ad.removeLast();
        assertEquals(i, 1);

        assertEquals(ad.size(), 0);
        assertTrue(ad.isEmpty());

        // remove from empty ad
        assertNull(ad.removeLast());
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);

        assertEquals((int) ad.get(0), 1);
        assertEquals((int) ad.get(0), 1);
        assertEquals((int) ad.get(0), 1);
    }

    @Test
    public void testPrintDeque() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        System.out.println("----testPrintDeque() start----");
        ad.printDeque();
        System.out.println("should be \"1, 2, 3\"");
        System.out.println("----testPrintDeque() end----");
    }

    @Test
    public void testAll() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < 50; i += 1) {
            ad.addLast(i);
        }
        for (int i = 0; i < 20; i += 1) {
            ad.removeFirst();
        }
        for (int i = 0; i < 20; i += 1) {
            ad.removeLast();
        }
        ad.printDeque();
        System.out.println("should be 20~29");
    }
}
