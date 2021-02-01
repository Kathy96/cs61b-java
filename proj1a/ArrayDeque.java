public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            nextFirst = plusOne(nextFirst);
            newArray[i] = items[nextFirst];
        }

        items = newArray;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size++;
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        size++;
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }


    public void printDeque() {

        int curr = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[curr] + " ");
            curr = (curr + 1) % items.length;

        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        nextFirst = plusOne(nextFirst);
        T firstItem = items[nextFirst];
        items[nextFirst] = null;
        nextFirst = nextFirst;

        if (items.length >= 16 && size < items.length * 0.25) {
            resize(items.length / 2);
        }

        size--;
        return firstItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        nextLast = minusOne(nextLast);
        T lastItem = items[nextLast];
        items[nextLast] = null;
        nextLast = nextLast;

        if (items.length >= 16 && size < items.length * 0.25) {
            resize(items.length / 2);
        }

        size--;
        return lastItem;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }

        return items[(nextFirst + 1 + index) % items.length];
    }

}






