package util;

/**
 * Pile générique au fonctionnement Last In First Out
 * @param <T> Le type des valeurs de la pile
 * @author Dorian Gillioz & Eric Peronetti
 */
public class Stack<T> {
    /**
     * Sommet de la stack
     */
    private final StackElement<T> head;

    /**
     * Nombre de valeurs dans la Stack
     */
    private int count;

    /**
     * Constructeur de la stack, va initialiser le sommet de la Pile générique
     */
    public Stack() {
        head = new StackElement<>(null, null);
        count = 0;
    }

    /**
     * Ajoute un objet T au sommet de la pile
     * @param value La valeur de l'objet à ajouter
     */
    public void push(T value) {
        head.next = new StackElement<>(head.next, value);
        ++count;
    }

    /**
     * Supprime l'objet en sommet de pile
     * @return l'objet supprimé
     * @throws RuntimeException Si la stack est vide
     */
    public T pop() {
        if (head.next == null)
            throw new RuntimeException("La stack est vide !");
        T popped_value = head.next.value;
        head.next = head.next.next;
        --count;
        return popped_value;
    }

    /**
     * Donne la stack actuelle sous le format [ <x> <y> <z> ... ]
     * @return la stack au format String
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        StackIterator<T> it = iterator();
        res.append("[ ");
        while (it.hasNext()) {
            res.append('<').append(it.next()).append('>').append(' ');
        }
        res.append(']');
        return res.toString();
    }

    /**
     * Convertit la stack actuelle en un tableau d'Object
     * @return le tableau d'Object convertit
     */
    public Object[] toArray() {
        Object[] ret = new Object[count];
        StackIterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            ret[i++] = it.next();
        }
        return ret;
    }

    /**
     * Donne un itérateur qui commence au sommet de la stack
     * @return l'itérateur au sommet de la stack
     */
    public StackIterator<T> iterator() {
        return new StackIterator<>(head);
    }
}
