package org.example.linked_list;

/**
 * An ordered collection. Implements part of the {@link java.util.List List} interface.
 *
 * @param <E> the type of elements in this list
 * @author Nick Kuzmenkov
 * @see java.util.List List
 */
public interface CustomList<E> {
    int size();

    boolean isEmpty();

    boolean contains(E e);

    boolean add(E e);

    void add(int index, E e);

    boolean remove(E e);

    E remove(int index);

    E get(int index);

    E set(int index, E e);

    void clear();
}