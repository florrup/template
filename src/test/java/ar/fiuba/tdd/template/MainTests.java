package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTests {

    /* Testing LinkedList */

    @Test
    public void createEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void createLinkedListSizeZero() {
        LinkedList list = new LinkedList();
        assertEquals(list.size(), 0);
    }

    @Test
    public void emptyLinkedListHasNoValue() {
        LinkedList list = new LinkedList();
        try {
            list.firstValue();
            assert false;
        } catch (AssertionError e) {
            assert true; // Exception caught
        }
    }

    @Test
    public void emptyLinkedListFirstNotDeletable() {
        LinkedList list = new LinkedList();
        try {
            list.deleteFirst();
            assert false;
        } catch (AssertionError e) {
            assert true; // Exception caught
        }
    }

    @Test
    public void addValueToLinkedList() {
        LinkedList list = new LinkedList();
        int value = 5;
        list.add(value);
        assertFalse(list.isEmpty());
        assertEquals(list.size(), 1);
        assertEquals(list.firstValue(), value);
    }

    @Test
    public void addNumerousValuesToLinkedList() {
        LinkedList list = new LinkedList();
        String stringValue = "flor";
        int maxStrings = 5;
        for (int i = 0; i < maxStrings; i++) {
            list.add(stringValue);
        }
        int numericValue = 4;
        int maxNumbers = 50;
        for (int i = 0; i < maxNumbers; i++) {
            list.add(numericValue);
        }

        assertFalse(list.isEmpty());
        assertEquals(list.size(), maxStrings + maxNumbers);
        assertEquals(list.firstValue(), stringValue); // should be "flor"
    }

    @Test
    public void deleteNumerousValuesFromLinkedList() {
        LinkedList list = new LinkedList();
        String stringValue = "flor";
        int maxStrings = 5;
        for (int i = 0; i < maxStrings; i++) {
            list.add(stringValue);
        }
        int numericValue = 4;
        int maxNumbers = 50;
        for (int i = 0; i < maxNumbers; i++) {
            list.add(numericValue);
        }

        list.deleteFirst();
        assertFalse(list.isEmpty());
        assertEquals(list.size(), maxStrings + maxNumbers - 1);
        assertEquals(list.firstValue(), stringValue); // there are still maxStrings - 1

        for (int i = 0; i < maxStrings - 1; i++) {
            list.deleteFirst();
        }

        assertFalse(list.isEmpty());
        assertEquals(list.size(), maxNumbers);
        assertEquals(list.firstValue(), numericValue);

        for (int i = 0; i < maxNumbers; i++) {
            list.deleteFirst();
        }

        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);

        try {
            list.deleteFirst();
            assert false;
        } catch (AssertionError e) {
            assert true; // Exception caught
        }
    }
}
