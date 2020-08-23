package com.hbq.aop.datastructure;

import java.util.Arrays;
import java.util.Stack;

public class MaxTopBinaryHeap implements Heap {

    private int[] data;

    private final int d = 2;

    private int size;

    public MaxTopBinaryHeap(int capacity) {
        this.data = new int[capacity + 1];
        this.size = 0;
        Arrays.fill(data, -1);
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public boolean isFull() {
        return size == data.length - 1;
    }

    @Override
    public int parent(int i) {
        return (i - 1) / d;
    }

    @Override
    public int kthChild(int i, int k) {
        return i * d + k;
    }

    @Override
    public void insert(int x) {
        if (isFull()) {
            printHeap();
            throw new RuntimeException("Heap is full, no space to insert new element.");
        }

        data[size++] = x;
        heapifyUp(size - 1);
    }

    @Override
    public int delete(int i) {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty, no element to delete.");
        }

        int element = data[i];
        data[i] = data[size - 1];
        size--;
        heapifyDown(i);
        return element;
    }

    @Override
    public void heapifyUp(int i) {
        int insertValue = data[i];
        while (i > 0 && insertValue > data[parent(i)]) {
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = insertValue;

    }

    @Override
    public void heapifyDown(int i) {
        int child;
        int t = data[i];
        while (kthChild(i, 1) < size) {
            child = maxChild(i);
            if (t >= data[child]) {
                break;
            }
            data[i] = data[child];
            i = child;
        }
        data[i] = t;
    }

    @Override
    public int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return data[leftChild] > data[rightChild] ? leftChild : rightChild;
    }

    @Override
    public int minChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return data[leftChild] > data[rightChild] ? rightChild : leftChild;
    }

    @Override
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty.");
        }
        return data[0];
    }

    @Override
    public int findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty.");
        }
        int[] t = new int[data.length];
        System.arraycopy(data, 0, t, 0, t.length);
        Stack<Integer> stack = new Stack<>();
        int tSize = size;
        for (int i = 0; i < tSize; i++) {
            stack.push(delete(0));
        }
        data = new int[t.length];
        size = t.length -1;
        System.arraycopy(t, 0, data, 0, t.length);
        return stack.peek();
    }

    public static void main(String[] args) {
        MaxTopBinaryHeap maxHeap = new MaxTopBinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(11);
        maxHeap.insert(12);
        maxHeap.insert(13);
//        maxHeap.insert(14);
//        maxHeap.insert(15);


//        maxHeap.printHeap();
//        maxHeap.delete(5);
//        maxHeap.printHeap();
//        maxHeap.delete(2);
//        maxHeap.printHeap();
//        for (int i = 0; i < 11; i++) {
//            System.out.print(maxHeap.delete(0) + " ");
//        }
        System.out.println(maxHeap.findMax());
        maxHeap.printHeap();
        System.out.println(maxHeap.findMin());
        maxHeap.printHeap();
    }
}
