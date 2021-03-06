package ar.fiuba.tdd.template;

class LinkedList<T> {

    private Node first;

    private class Node {

        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
            this.next = null;
        }

        // Adds new node at the end of the list
        void addNext(T value) {
            if (this.next == null) {
                this.next = new Node(value);
            } else {
                this.next.addNext(value);
            }
        }
    }

    LinkedList() {
        first = null;
    }

    int size() {
        return countNodes(this.first);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return (1 + countNodes(node.next));
    }

    boolean isEmpty() {
        return (this.size() == 0);
    }

    void add(T value) {
        if (!this.isEmpty()) {
            this.first.addNext(value); // add value at the end of the list to the last node
        } else {
            this.first = new Node(value);
        }
    }

    void deleteFirst() throws AssertionError {
        if (this.isEmpty()) {
            System.out.println("Trying to delete from an empty list");
            throw new AssertionError();
        } else {
            this.first = this.first.next;
        }
    }

    T firstValue() throws AssertionError {
        if (this.isEmpty()) {
            System.out.println("Trying to read from an empty list");
            throw new AssertionError();
        } else {
            return this.first.value;
        }
    }

}
