package util;

public class StackIterator<T> {
    private StackElement<T> current;

    StackIterator(StackElement<T> head) {
        current = head;
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public StackElement<T> next() {
        current = current.next;
        return current;
    }
}
