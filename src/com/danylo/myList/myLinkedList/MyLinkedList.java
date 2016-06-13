package com.danylo.myList.myLinkedList;

import com.danylo.myList.List;

public class MyLinkedList<E> implements List<E> {
    private class Node {
        E value;
        Node prev;
        Node next;
        Node(E value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (size == 0) {
            first = new Node(element);
            last = first;
        }
        else {
            Node node = new Node(element);
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    @Override
    public void add(E element, int index) {
        checkRangeForAdd(index);
        Node prev = first;
        Node next = null;
        if (size == 0 && index == 0) {
            add(element);
        }
        else if (index == 0) {
            Node node = new Node(element);
            node.next = first;
            first.prev = node;
            first = node;
            size++;
        }
        else if (index == size) {
            addLast(element);
        }
        else {
            if (index < size / 2) {
                for (int i = 1; i < index; i++) {
                    prev = prev.next;
                }
            }
            else {
                prev = last;
                for (int i = size - 1; i >= index; i--) {
                    prev = prev.prev;
                }
            }
            next = prev.next;
            Node node = new Node(element);
            node.prev = prev;
            node.next = next;
            prev.next = node;
            next.prev = node;
            size++;
        }
    }



    @Override
    public E get(int index) {
        checkRange(index);
        Node node = null;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node.value;
    }

    @Override
    public void remove(E element) {
        if (size == 0) {
            return;
        }
        Node temp = first;
        if (temp.value.equals(element)) {
            removeFirst();
        }
        else {
            for (int i = 1; i < size(); i++) {
                temp = temp.next;
                if (temp.value.equals(element)) {
                    if (temp!= last) {
                        removeTemp(temp);
                    }
                    else {
                        temp.value = null;
                        last = temp.prev;
                        size--;
                    }
                }
            }
        }

    }

    @Override
    public void remove(int index) {
        checkRange(index);
        if (index == 0) {
            removeFirst();
        }
        else if (index == size - 1) {
            last.value = null;
            last = last.prev;
            size--;
        }
        else {
            if (index < size / 2) {
                Node temp = first;
                for (int i = 1; i <= index; i++) {
                    temp = temp.next;
                }
                removeTemp(temp);
            }
            else {
                Node temp = last;
                for (int i = size - 2; i >= index; i--) {
                    temp = last.prev;
                }
                removeTemp(temp);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(E element, int index) {
        checkRange(index);
        if (index > size / 2) {
            Node node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.value = element;
        }
        else {
            Node node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            node.value = element;
        }
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int indexOf(E element) {
        if (size > 0) {
            Node temp = first;
            for (int i = 0; i < size; i++) {
                if (temp.value.equals(element)) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        if (size > 0) {
            Node temp = last;
            for (int i = size - 1; i >= 0; i--) {
                if (temp.value.equals(element)) {
                    return i;
                }
                temp = temp.prev;
            }
        }
        return -1;
    }

    private void checkRangeForAdd(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void checkRange(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void removeFirst() {
        if (first.next != null) {
            first = first.next;
        }
        size--;
    }

    private void removeTemp(Node temp) {
        temp.value = null;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    private void addLast(E element) {
        Node node = new Node(element);
        node.prev = last;
        last.next = node;
        last = node;
        size++;
    }
}
