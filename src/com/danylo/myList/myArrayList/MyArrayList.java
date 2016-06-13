package com.danylo.myList.myArrayList;

import com.danylo.myList.List;

public class MyArrayList<E> implements List<E> {
    private Object[] array = new Object[100];
    private int size;



    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        enlarge();
        array[size++] = element;
//        size++;
    }

    @Override
    public void add(E element, int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == size()) {
            enlarge();
            add(element);
        }
        else {
            enlarge();
            System.arraycopy(array, index, array, index + 1, size  - index);
            array[index] = element;
            size++;
        }
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return (E)array[index];
    }

    @Override
    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public void remove(int index) {
        checkRange(index);
        System.arraycopy(array, index + 1, array, index, size  - index);
        array[size-- - 1] = null;
//            size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(E element, int index) {
        checkRange(index);
        array[index] = element;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals((E)element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < size - 1; i++) {
            out.append(array[i].toString());
            out.append(", ");
        }
        out.append(array[size - 1].toString());
        out.append("]");
        return out.toString();
    }

    private void checkRange(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void enlarge() {
        if (array.length == size) {
            Object[] enlarged = new Object[size * 2];
            System.arraycopy(array, 0, enlarged, 0, size - 1);
            array = enlarged;
        }
    }
}
