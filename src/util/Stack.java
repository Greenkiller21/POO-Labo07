package util;

public class Stack<T> {
    StackElement<T> head;
    private int count;  // nombre de valeurs dans la Stack

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
     * @return l'objet supprimé, null si la stack est vide
     */
    public T pop() {
        if (head.next == null) return null;
        T popped_value = head.next.value;
        head.next = head.next.next;
        --count;
        return popped_value;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        StackIterator<T> it = iterator();
        while (it.hasNext()) {
            res.append(it.next().value.toString());
            if (it.hasNext()) res.append(" ");
        }
        return res.toString();
    }

    public Object[] toArray() {
        Object[] ret = new Object[count];
        StackIterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            ret[i++] = it.next().value;
        }
        return ret;
    }

    public StackIterator<T> iterator() {
        return new StackIterator<>(head);
    }
}
