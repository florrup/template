package ar.fiuba.tdd.template;

/**
 * Created by florencia on 27/08/16.
 */

public class LinkedList<T> {

    private Node first;

    private class Node<T> {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        // Agrego al final el next node
        public void addNext(T value) {
            if (this.next == null) {
                this.next = new Node(value);
            } else {
                this.next.addNext(value);
            }
        }
    }

    public LinkedList() {
        first = null;
    }

    public int size() {
        return countNodes(this.first);
    }

    private int countNodes(Node<T> node) {
        if (node == null) return 0;
        return (1 + countNodes(node.next));
    }

    public boolean isEmpty() {
        return (this.size() == 0);
    }

    public void add(T value) {
        if (!this.isEmpty()) {
            this.first.addNext(value);
        } else {
            Node node = new Node(value);
            this.first = node;
        }
    }

    public void deleteFirst() throws AssertionError {
        if (this.isEmpty()) {
            System.out.println("Trying to delete from an empty list");
            throw new AssertionError();
        } else {
            this.first = this.first.next;
        }
    }

    public T firstValue() throws AssertionError {
        if (this.isEmpty()) {
            System.out.println("Trying to read from an empty list");
            throw new AssertionError();
        } else {
            return ((T) (this.first.value));
        }
    }

}
