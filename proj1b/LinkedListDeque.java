public class LinkedListDeque<T> implements Deque<T> {
    private int size;
    private Node sentinel;

    private class Node {
        Node prev;
        T item;
        Node next;

        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;

        size++;

    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;

        size++;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node temp = sentinel.next;
        while (temp != sentinel) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = sentinel.next;

        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return first.item;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node last = sentinel.prev;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last.item;
    }
    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node currNode = sentinel.next;
        while (index > 0) {
            currNode = currNode.next;
            index--;
        }
        return currNode.item;
    }

    public T getRecursive(int index) {
        Node currNode = sentinel.next;
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(index, currNode);
    }

    private T getRecursiveHelper(int index, Node currNode) {
        if (index == 0) {
            return currNode.item;
        }
        return getRecursiveHelper(index - 1, currNode.next);
    }
}



