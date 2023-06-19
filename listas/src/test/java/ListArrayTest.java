import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListArrayTest {
    private ListArray<Integer> enteros;

    @BeforeEach
    void setUp() {
        enteros = new ListArray<>();
    }

    @Test
    void testClear() {
        enteros.append(10);
        enteros.append(20);
        enteros.clear();
        assertEquals(0, enteros.length());
        assertThrows(NoSuchElementException.class, () -> {
            enteros.getValue();
        });
    }

    @Test
    void testInsert() {
        enteros.insert(10);
        assertEquals(1, enteros.length());
        enteros.insert(20);
        assertEquals(2, enteros.length());
        assertEquals(20, enteros.getValue());
        enteros.moveToEnd();
        assertEquals(10, enteros.getValue());
    }

    @Test
    void testAppend() {
        enteros.append(10);
        assertEquals(1, enteros.length());
        enteros.append(20);
        assertEquals(2, enteros.length());
        enteros.moveToStart();
        assertEquals(10, enteros.getValue());
        enteros.moveToEnd();
        assertEquals(20, enteros.getValue());
    }

    @Test
    void testRemove() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToEnd();
        assertEquals(20, enteros.remove());
        assertEquals(1, enteros.length());
        assertEquals(10, enteros.remove());
        assertEquals(0, enteros.length());
        assertThrows(NoSuchElementException.class, () -> {
            enteros.remove();
        });
    }

    @Test
    void testMoveToStart() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToStart();
        assertEquals(10, enteros.getValue());
    }

    @Test
    void testMoveToEnd() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToEnd();
        assertEquals(20, enteros.getValue());
    }

    @Test
    void testPrev() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToEnd();
        enteros.prev();
        assertEquals(10, enteros.getValue());
        enteros.prev();
        assertEquals(10, enteros.getValue());
    }

    @Test
    void testNext() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToStart();
        enteros.next();
        assertEquals(20, enteros.getValue());
        enteros.next();
        assertEquals(20, enteros.getValue());
    }

    @Test
    void testLength() {
        assertEquals(0, enteros.length());
        enteros.append(10);
        assertEquals(1, enteros.length());
        enteros.remove();
        assertEquals(0, enteros.length());
    }

    @Test
    void testCurrPos() {
        enteros.append(10);
        enteros.append(20);
        enteros.moveToStart();
        assertEquals(0, enteros.currPos());
        enteros.next();
        assertEquals(1, enteros.currPos());
    }

    @Test
    void testMoveToPos() {
        enteros.append(10);
        enteros.insert(20);
        enteros.moveToPos(0);
        assertEquals(20, enteros.getValue());
        enteros.moveToPos(1);
        assertEquals(10, enteros.getValue());
    }

    @Test
    void testIsAtEnd() {
        enteros.append(10);
        enteros.insert(20);
        enteros.moveToStart();
        assertFalse(enteros.isAtEnd());
        enteros.moveToEnd();
        assertTrue(enteros.isAtEnd());
    }

    @Test
    void testGetValue() {
        assertThrows(NoSuchElementException.class, () -> {
            enteros.getValue();
        });
        enteros.append(10);
        enteros.insert(20);
        enteros.moveToStart();
        assertEquals(20, enteros.getValue());
        enteros.moveToEnd();
        assertEquals(10, enteros.getValue());
    }

    @Test
    void testIsEmpty() {
        assertTrue(enteros.isEmpty());
        enteros.append(10);
        assertFalse(enteros.isEmpty());
    }
}