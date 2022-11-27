package util;

/**
 * Element générique de la pile qui contient sa valeur et l'élément suivant
 * @param <T> Type de la valeur de l'élément, doit être le même que la pile
 */
class StackElement<T> {
    /**
     * Element suivant de la stack
     */
    StackElement<T> next;

    /**
     * Valeur de l'élément
     */
    T value;

    /**
     * Constructeur de l'élément de la pile
     * @param next Element suivant de l'élément dans la pile
     * @param value Valeur de l'élément
     */
    StackElement(StackElement<T> next, T value) {
        this.next = next;
        this.value = value;
    }
}
