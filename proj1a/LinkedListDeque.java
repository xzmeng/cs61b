public class LinkedListDeque<T> {
    private static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T item;
        Node(T item, Node<T> prev, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private int size;
    private Node<T> sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }


    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
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
        if (size() == 0) {
            return null;
        }
        Node<T> node = sentinel.next;
        node.next.prev = sentinel;
        sentinel.next = node.next;
        size -= 1;
        return node.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (size() == 0) {
            return null;
        }
        Node<T> node = sentinel.prev;
        node.prev.next = sentinel;
        sentinel.prev = node.prev;
        size -= 1;
        return node.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (index > size() - 1) {
            return null;
        }
        Node<T> node = sentinel.next;
        while (index > 0) {
            node = node.next;
            index -= 1;
        }
        return node.item;
    }

    private T getRecursive(int index, Node<T> node) {
        if (index == 0) {
            return node.item;
        } else {
            return getRecursive(index - 1, node.next);
        }
    }

    public T getRecursive(int index) {
        if (index > size() - 1) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }
}
