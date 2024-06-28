package ru.practice.secondpractice;

public class Queue<T> {
    private final DoublyLinkedList<T> list;

    public Queue() {
        list = new DoublyLinkedList<>();
    }

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}