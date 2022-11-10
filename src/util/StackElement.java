package util;

class StackElement<T> {
    StackElement<T> next;
    T value;

    public StackElement(StackElement<T> next, T value) {
        this.next = next;
        this.value = value;
    }
}
