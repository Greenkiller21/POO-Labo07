package util;

/**
 * Itérateur générique sur une pile du même type générique
 * @param <T> Le type de l'élément de l'itérateur, doit être le même que la pile
 */
public class StackIterator<T> {
    /**
     * Element de la stack pointée actuellement par l'itérateur
     */
    private StackElement<T> current;

    /**
     * Constructeur de l'itérateur qui commence à la position
     * de la stack donnée en paramètre
     * @param head Début de l'itérateur
     */
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
    public T next() {
        current = current.next;
        return current.value;
    }
}
