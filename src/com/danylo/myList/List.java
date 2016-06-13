package com.danylo.myList;

public interface List<E> {
    int size();
    void add(E element);
    void add(E element, int index);
    Object get(int index);
    void remove(E element);
    void remove(int index);
    boolean isEmpty();
    void set(E element, int index);
    boolean contains(E element);
    void clear();
    int indexOf(E element);
    int lastIndexOf(E element);
    String toString();
}
