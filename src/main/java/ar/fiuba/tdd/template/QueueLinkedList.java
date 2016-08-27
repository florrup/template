package ar.fiuba.tdd.template;

class QueueLinkedList<T> implements Queue<T> {

    private LinkedList<T> list;

    QueueLinkedList() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void add(T item) {
        list.add(item); // the item is added at the end of the list, important for a queue implementation!
    }

    public T top() {
        return (list.firstValue());
    }

    public void remove() {
        list.deleteFirst();
    }

}
