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

    /* Testing QueueLinkedList */

    @Test
    public void createEmptyQueue() {
        QueueLinkedList queue = new QueueLinkedList();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void createQueueSizeZero() {
        QueueLinkedList queue = new QueueLinkedList();
        assertEquals(queue.size(), 0);
    }

    @Test
    public void emptyQueueHasNoValue() {
        QueueLinkedList queue = new QueueLinkedList();
        try {
            queue.top();
            assert false;
        } catch (AssertionError e) {
            System.out.println("The queue is empty, so top value cannot be read");
            assert true;
        }
    }

    @Test
    public void emptyQueueNotDeleteable() {
        QueueLinkedList queue = new QueueLinkedList();
        try {
            queue.remove();
            assert false;
        } catch (AssertionError e) {
            System.out.println("The queue is empty, so top value cannot be removed");
            assert true;
        }
    }

    @Test
    public void addValueToQueue() {
        QueueLinkedList queue = new QueueLinkedList();
        String value = "testing";
        queue.add(value);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 1);
        assertEquals(queue.top(), value);
    }

    @Test
    public void addNumerousValuesToQueue() {
        QueueLinkedList queue = new QueueLinkedList();
        String stringValue = "flor";
        int maxStrings = 125;
        for (int i = 0; i < maxStrings; i++) {
            queue.add(stringValue);
        }
        int numericValue = 3;
        int maxNumbers = 500;
        for (int i = 0; i < maxNumbers; i++) {
            queue.add(numericValue);
        }

        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), maxStrings + maxNumbers);
        assertEquals(queue.top(), stringValue); // should be "flor"
    }


    @Test
    public void deleteNumerousValuesFromQueue() {
        QueueLinkedList queue = new QueueLinkedList();
        String stringValue = "flor";
        int maxStrings = 125;
        for (int i = 0; i < maxStrings; i++) {
            queue.add(stringValue);
        }
        int numericValue = 3;
        int maxNumbers = 500;
        for (int i = 0; i < maxNumbers; i++) {
            queue.add(numericValue);
        }

        queue.remove();
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), maxStrings + maxNumbers - 1);
        assertEquals(queue.top(), stringValue); // there are still maxStrings - 1

        for (int i = 0; i < maxStrings - 1; i++) {
            queue.remove();
        }

        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), maxNumbers);
        assertEquals(queue.top(), numericValue);

        for (int i = 0; i < maxNumbers; i++) {
            queue.remove();
        }

        assertTrue(queue.isEmpty()); // queue is now empty
        assertEquals(queue.size(), 0);

        try {
            queue.remove();
            assert false;
        } catch (AssertionError e) {
            System.out.println("The " + (maxStrings + maxNumbers) + " values have been removed. The queue is now empty.\n" +
                    "Top value cannot be removed");
            assert true; // Exception caught
        }
    }
}
