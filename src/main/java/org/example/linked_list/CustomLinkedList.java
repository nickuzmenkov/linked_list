package org.example.linked_list;

import java.util.Objects;

public class CustomLinkedList<E> implements CustomList<E> {
    private Node<E> head;

    @Override
    public int size() {
        int size = 0;
        Node<E> node = head;
        while (node != null) {
            node = node.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public boolean contains(E e) {
        Node<E> node = head;
        while (node != null) {
            if (node.getValue().equals(e)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<E> node = head;
            while (node.hasNext()) {
                node = node.getNext();
            }
            node.setNext(newNode);
            newNode.setPrevious(node);
        }
        return true;
    }

    @Override
    public void add(int index, E e) {
        Objects.checkIndex(index, size() + 1);
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            if (head != null) {
                newNode.setNext(head);
                head.setPrevious(newNode);
            }
            head = newNode;
        } else if (index == size()) {
            add(e);
        } else {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            newNode.setNext(node);
            newNode.setPrevious(node.getPrevious());
            node.getPrevious().setNext(newNode);
            node.setPrevious(newNode);
        }
    }

    @Override
    public boolean remove(E e) {
        Node<E> node = head;
        while (node != null) {
            if (node.getValue().equals(e)) {
                if (node.hasPrevious()) {
                    node.getPrevious().setNext(node.getNext());
                }
                if (node.hasNext()) {
                    node.getNext().setPrevious(node.getPrevious());
                }
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size());
        if (index == 0) {
            E value = head.getValue();
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            }
            return value;
        } else {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            E value = node.getValue();
            if (node.hasNext()) {
                node.getNext().setPrevious(node.getPrevious());
            }
            if (node.hasPrevious()) {
                node.getPrevious().setNext(node.getNext());
            }
            return value;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size());
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public E set(int index, E e) {
        Objects.checkIndex(index, size());
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        E previousValue = node.getValue();
        node.setValue(e);
        return previousValue;
    }

    @Override
    public void clear() {
        head = null;
    }
}
