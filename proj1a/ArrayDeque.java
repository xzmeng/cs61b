public class ArrayDeque<Item> {
    private int size;
    private int capacity;
    private Item[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        items = (Item[]) new Object[capacity];
        nextFirst = capacity - 1;
        nextLast = 0;
    }

    /**
     * helper methods
     */
    private boolean isFull() {
        return size() == capacity;
    }

    private boolean isSparse() {
        return (double) size / (double) capacity < 0.25
                && capacity >= 16;
    }

    private void upCapacity() {
        int newCapacity = capacity * 2;
        Item[] newItems = (Item[]) new Object[newCapacity];
        copyItems(items, newItems);
    }

    private void downCapacity() {
        int newCapacity = capacity / 2;
        Item[] newItems = (Item[]) new Object[newCapacity];
        copyItems(items, newItems);
    }

    private int plusOne(int i) {
        return (i + 1) % capacity;
    }

    private int minusOne(int i) {
        return (i - 1) % capacity;
    }

    private void copyItems(Item[] oldItems, Item[] newItems) {
        int index = plusOne(nextFirst);
        for (int i = 0; i < capacity; i += 1) {
            newItems[i] = items[index];
            index = plusOne(index);
        }
        capacity = newItems.length;
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /**
     * Adds an item of type Item to the front of the deque.
     */
    public void addFirst(Item item) {
        if (isFull()) {
            upCapacity();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }


    /**
     * Adds an item of type Item to the back of the deque.
     */
    public void addLast(Item item) {
        if (isFull()) {
            upCapacity();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        size -= 1;
        Item item = items[nextFirst];
        if (isSparse()) {
            downCapacity();
        }
        return item;
    }


    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    public Item removeLast() {
        if (size() == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        size -= 1;
        Item item = items[nextLast];
        if (isSparse()) {
            downCapacity();
        }
        return item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public Item get(int index) {
        return items[(nextFirst + 1 + index) % capacity];
    }

}
