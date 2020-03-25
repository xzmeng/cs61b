public class ArrayDeque<T> {
    private int size;
    private int capacity;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        items = (T[]) new Object[capacity];
        nextFirst = capacity - 1;
        nextLast = 0;
    }

    /** full */
    private boolean isFull() {
        return size() == capacity;
    }
    /** sparse */
    private boolean isSparse() {
        return (double) size / (double) capacity < 0.25
                && capacity >= 16;
    }
    /** Plus i by one circularly */
    private int plusOne(int i) {
        return (i + 1) % capacity;
    }
    /** Minus i by one circularly */
    private int minusOne(int i) {
        return (i - 1 + capacity) % capacity;
    }
    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        int oldIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i += 1) {
            newItems[i] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        capacity = newCapacity;
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }


    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        if (isFull()) {
            resize(capacity * 2);
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
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i));
            if (i != size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        size -= 1;
        T toRemove = items[nextFirst];
        items[nextFirst] = null;
        if (isSparse()) {
            resize(capacity / 2);
        }
        return toRemove;
    }


    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        nextLast = minusOne(nextLast);
        size -= 1;
        T toRemove = items[nextLast];
        items[nextLast] = null;
        if (isSparse()) {
            resize(capacity / 2);
        }
        return toRemove;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        return items[(nextFirst + 1 + index) % capacity];
    }

}
