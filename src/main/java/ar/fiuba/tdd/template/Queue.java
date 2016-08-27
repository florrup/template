package ar.fiuba.tdd.template;

/**
 * Created by florencia on 27/08/16.
 */

public interface Queue<T> {
    boolean isEmpty();
    int size();
    void add(T item); // agregar un item
    T top(); // retornar el primer item, lanzar exception si esta vacio
    void remove(); // remover el primer item, lanzar exception si esta vacio
}
