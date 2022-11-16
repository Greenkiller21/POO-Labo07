package util;

public class StackIterator<T> {
    /**
     * Element de la stack pointée actuellement par l'itérateur
     */
    private StackElement<T> current;

    StackIterator(StackElement<T> head) {
        current = head;
    }

    /**
     * Détermine si il y a un élément suivant de la stack
     * @return true si il y a un élément suivant
     */
    public boolean hasNext() {
        return current.next != null;
    }

    /**
     * Donne l'élément suivant de la stack
     * @return l'élément suivant
     */
    public StackElement<T> next() {
        current = current.next;
        return current;
    }
}
