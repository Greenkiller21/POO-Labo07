package util;

import org.junit.jupiter.api.Test;

import java.net.Inet4Address;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void push() {
        //On vérifie que quand on ajoute la stack ait la bonne taille
        Stack<Integer> stack = new Stack<>();
        assertEquals(0, stack.toArray().length);
        stack.push(1);
        assertEquals(1, stack.toArray().length);
        stack.push(2);
        assertEquals(2, stack.toArray().length);
    }

    @Test
    void pop() {
        //On regarde que quand on pop des éléments on ait la bonne valeur et
        //qu'il n'y ait pas d'exception
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        //On vérifie que chaque pop retourne la bonne valeur et ne crash pas
        assertEquals(stack.toArray().length, 3);
        assertDoesNotThrow(() -> assertEquals(3, stack.pop()));

        assertEquals(stack.toArray().length, 2);
        assertDoesNotThrow(() -> assertEquals(2, stack.pop()));

        assertEquals(stack.toArray().length, 1);
        assertDoesNotThrow(() -> assertEquals(1, stack.pop()));

        //Si on pop une fois de trop on doit avoir une execption
        assertEquals(stack.toArray().length, 0);
        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void testToString() {
        //On regarde que le string soit correct pour 0 et 3 éléments
        Stack<Integer> stack = new Stack<>();
        assertEquals("[ ]", stack.toString());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("[ <3> <2> <1> ]", stack.toString());
    }

    @Test
    void toArray() {
        //On regarde que le toArray retourne un bon tableau
        Stack<Integer> stack = new Stack<>();

        assertArrayEquals(new Object[] {}, stack.toArray());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertArrayEquals(new Object[] {3, 2, 1}, stack.toArray());
    }

    @Test
    void iterator() {
        //On regarde que l'itérateur ait un comportment correct
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer elem;
        StackIterator<Integer> it = stack.iterator();

        //Element 3
        assertTrue(it.hasNext());
        elem = it.next();
        assertEquals(3, elem);

        //Element 2
        assertTrue(it.hasNext());
        elem = it.next();
        assertEquals(2, elem);

        //Element 1
        assertTrue(it.hasNext());
        elem = it.next();
        assertEquals(1, elem);

        //Vide
        assertFalse(it.hasNext());
    }
}