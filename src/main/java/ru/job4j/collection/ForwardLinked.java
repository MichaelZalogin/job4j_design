package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        final T element = head.value;
        final Node<T> tmp = head;
        head = head.next;
        tmp.next = null;
        tmp.value = null;
        return element;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean revert() {
        boolean result = !isEmpty() && head.next != null;
        if (result) {
            Node<T> one = null;
            Node<T> two = head;
            Node<T> three;
            while (two != null) {
                three = two.next;
                two.next = one;
                one = two;
                two = three;
            }
            head = one;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}