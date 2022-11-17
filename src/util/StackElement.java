package util;

class StackElement<T> {
    /**
     * Element suivant de la stack
     */
    StackElement<T> next;
    /**
     * Valeur de l'élément
     */
    T value;

    StackElement(StackElement<T> next, T value) {
        this.next = next;
        this.value = value;
    }
}
