package ar.fiuba.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        String secondValue = "florencia";
        int numSecondValue = 50;
        for (int i = 0; i < numSecondValue; i++) {
            list.add(secondValue);
        }

        assertFalse(list.isEmpty());
        assertEquals(list.size(), numFirstValue + numSecondValue);
        assertEquals(list.firstValue(), firstValue); // should be "flor"
    }

    @Test
    public void deleteNumerousValuesFromLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        int firstValue = 80;
        int numFirstValue = 50;
        for (int i = 0; i < numFirstValue; i++) {
            list.add(firstValue);
        }

        list.deleteFirst();
        assertFalse(list.isEmpty());
        assertEquals(list.size(), numFirstValue - 1);
        assertEquals(list.firstValue(), (Integer)firstValue); // there are still numFirstValue - 1

        for (int i = 0; i < numFirstValue - 1; i++) {
            list.deleteFirst();
        }

        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);
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
        int value = 88;
        int numValue = 125;
        for (int i = 0; i < numValue; i++) {
            queue.add(value);
        }

        queue.remove();
        assertFalse(queue.isEmpty());
        assertEquals(queue.size(), numValue - 1);
        assertEquals(queue.top(), (Integer)value); // there are still numValue - 1

        for (int i = 0; i < numValue - 1; i++) {
            queue.remove();
        }

        assertTrue(queue.isEmpty()); // queue is now empty
        assertEquals(queue.size(), 0);
    }
}
