package hanoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HanoiTest {
    @Test
    void Hanoi() {
        //Constructeur sans erreur
        assertDoesNotThrow(() -> new Hanoi(1));
        assertDoesNotThrow(() -> new Hanoi(1, new CmdHanoiDisplayer()));

        //Constructeur avec erreur
        assertThrows(RuntimeException.class, () -> new Hanoi(0));
        assertThrows(RuntimeException.class, () -> new Hanoi(-1));
        assertThrows(RuntimeException.class, () -> new Hanoi(1, null));
    }

    /**
     * On retourne true si l'aiguille finale est valide
     * Aiguille valide : le status de la taille des disque de la dernière
     * aiguille doit monter de 1 par 1 depuis 1 à nbDisk
     * Ex. : Avec 3 disques, l'aiguille finale doit avoir 1, 2, 3
     * @param finalRod Le status de l'aiguille finale
     * @return Si l'aiguille finale est valide
     */
    boolean isFinalRodLegal(int[] finalRod) {
        int current = 1;
        for (int diskSize : finalRod) {
            if (diskSize != current) {
                return false;
            }
            current++;
        }
        return true;
    }

    @Test
    void solve() {
        //L'aiguille finale est inversée
        assertFalse(isFinalRodLegal(new int[] {3, 2, 1}));
        //L'aiguille finale à ces deux disques du dessus inversés
        assertFalse(isFinalRodLegal(new int[] {2, 1, 3}));
        //L'aiguille est correcte
        assertTrue(isFinalRodLegal(new int[] {1, 2, 3}));

        Hanoi h = new Hanoi(3, new NothingHanoiDisplayer());
        h.solve();
        //A la fin de solve l'on doit avoir finished à true
        assertTrue(h.finished());
        //Le nombre de disques déplacés doit être 2^nbDisks - 1
        assertEquals(Math.pow(2, 3) - 1, h.turn());
        assertTrue(isFinalRodLegal(h.status()[2]));

        h = new Hanoi(6, new NothingHanoiDisplayer());
        h.solve();
        //A la fin de solve l'on doit avoir finished à true
        assertTrue(h.finished());
        //Le nombre de disques déplacés doit être 2^nbDisks - 1
        assertEquals(Math.pow(2, 6) - 1, h.turn());
        assertTrue(isFinalRodLegal(h.status()[2]));
    }

    @Test
    void status() {
        Hanoi h = new Hanoi(3, new NothingHanoiDisplayer());
        assertArrayEquals(new int[] { 1, 2, 3 }, h.status()[0]);
        assertEquals(0, h.status()[1].length);
        assertEquals(0, h.status()[2].length);
    }

    @Test
    void finished() {
        Hanoi h = new Hanoi(3, new NothingHanoiDisplayer());
        //Quand on a pas encore commencé, on ne doit pas avoir finished à true
        assertFalse(h.finished());
        h.solve();
        //Quand on a fini, finished doit être à true
        assertTrue(h.finished());
    }

    @Test
    void turn() {
        Hanoi h = new Hanoi(3, new NothingHanoiDisplayer());
        //Avant de commencer on doit être au tour 0
        assertEquals(0, h.turn());
        h.solve();
        //A la fin on doit être au tour 2^nbDisks - 1
        assertEquals(Math.pow(2, 3) - 1, h.turn());
    }

    @Test
    void testToString() {
        Hanoi h = new Hanoi(3, new NothingHanoiDisplayer());
        //L'affichage pour le premier tour
        assertEquals(h.toString(), """
                        -- Turn: 0
                        One:   [ <1> <2> <3> ]
                        Two:   [ ]
                        Three: [ ]""");
        h.solve();
        //L'affichage pour le dernier tour
        assertEquals(h.toString(), """
                        -- Turn: 7
                        One:   [ ]
                        Two:   [ ]
                        Three: [ <1> <2> <3> ]""");
    }
}