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
        LinkedList<Integer> list = new LinkedList<>();
        int value = 5;
        list.add(value);
        assertFalse(list.isEmpty());
        assertEquals(list.size(), 1);
        assertEquals(list.firstValue(), (Integer)value);
    }

    @Test
    public void addNumerousValuesToLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        String firstValue = "flor";
        int numFirstValue = 5;
        for (int i = 0; i < numFirstValue; i++) {
            list.add(firstValue);
        }
        String secondString = "florencia";
        int numSecondString = 50;
        for (int i = 0; i < numSecondString; i++) {
            list.add(secondString);
        }

        assertFalse(list.isEmpty());
        assertEquals(list.size(), numFirstValue + numSecondString);
        assertEquals(list.firstValue(), firstValue); // should be "flor"
    }

    @Test
    public void deleteNumerousValuesFromLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        int firstValue = 80;
        int numFirstValue = 5;
        for (int i = 0; i < numFirstValue; i++) {
            list.add(firstValue);
        }
        int secondValue = 4;
        int numSecondValue = 50;
        for (int i = 0; i < numSecondValue; i++) {
            list.add(secondValue);
        }

        list.deleteFirst();
        assertFalse(list.isEmpty());
        assertEquals(list.size(), numFirstValue + numSecondValue - 1);
        assertEquals(list.firstValue(), (Integer)firstValue); // there are still maxStrings - 1

        for (int i = 0; i < numFirstValue - 1; i++) {
            list.deleteFirst();
        }

        assertFalse(list.isEmpty());
        assertEquals(list.size(), numSecondValue);
        assertEquals(list.firstValue(), (Integer)secondValue);

        for (int i = 0; i < numSecondValue; i++) {
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
    public void emptyQueueNotDeletable() {
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
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        String value = "testing";
        queue.add(value);
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), 1);
        assertEquals(queue.top(), value);
    }

    @Test
    public void addNumerousValuesToQueue() {
        QueueLinkedList<String> queue = new QueueLinkedList<>();
        String firstValue = "flor";
        int numFirstValue = 125;
        for (int i = 0; i < numFirstValue; i++) {
            queue.add(firstValue);
        }
        String secondValue = "florencia111";
        int numSecondValue = 500;
        for (int i = 0; i < numSecondValue; i++) {
            queue.add(secondValue);
        }

        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), numFirstValue + numSecondValue);
        assertEquals(queue.top(), firstValue); // should be "flor"
    }

    @Test
    public void deleteNumerousValuesFromQueue() {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        int firstValue = 88;
        int numFirstValue = 125;
        for (int i = 0; i < numFirstValue; i++) {
            queue.add(firstValue);
        }
        int secondValue = 3;
        int numSecondValue = 500;
        for (int i = 0; i < numSecondValue; i++) {
            queue.add(secondValue);
        }

        queue.remove();
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), numFirstValue + numSecondValue - 1);
        assertEquals(queue.top(), (Integer)firstValue); // there are still maxStrings - 1

        for (int i = 0; i < numFirstValue - 1; i++) {
            queue.remove();
        }

        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), numSecondValue);
        assertEquals(queue.top(), (Integer)secondValue);

        for (int i = 0; i < numSecondValue; i++) {
            queue.remove();
        }

        assertTrue(queue.isEmpty()); // queue is now empty
        assertEquals(queue.size(), 0);

        try {
            queue.remove();
            assert false;
        } catch (AssertionError e) {
            System.out.println("The " + (numFirstValue + numSecondValue) + " values have been removed. The queue is now empty.\n" +
                    "Top value cannot be removed");
            assert true; // Exception caught
        }
    }
}
