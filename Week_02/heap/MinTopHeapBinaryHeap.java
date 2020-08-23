package com.hbq.aop.datastructure;

import java.util.Arrays;
import java.util.Stack;

public class MinTopHeapBinaryHeap implements Heap {
    private int[] data;

    private int size;

    private static final int d = 2;

    public MinTopHeapBinaryHeap(int capacity) {
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
        return data.length - 1 == size;
    }

    @Override
    public int parent(int i) {
        return (i - 1) / d;
    }

    @Override
    public int kthChild(int i, int k) {
        return d * i + k;
    }

    @Override
    public void insert(int x) {
        if (isFull()) {
            throw new RuntimeException("Heap is full, no space to insert.");
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
        int t = data[i];
        while (i > 0 && t < data[parent(i)]) {
            data[i] = data[parent(i)];
            i = parent(i);
        }
        data[i] = t;
    }

    @Override
    public void heapifyDown(int i) {
        int t = data[i];
        int child;
        while (kthChild(i, 1) < size) {
            child = minChild(i);
            if (t <= minChild(i)) {
                break;
            }
            data[i] = data[child];
            i = child;
        }
        data[i] = t;
    }

    @Override
    public int maxChild(int i) {
        int left = kthChild(i, 1);
        int right = kthChild(i, 2);
        return data[left] > data[right] ? left : right;
    }

    @Override
    public int minChild(int i) {
        int left = kthChild(i, 1);
        int right = kthChild(i, 2);
        return data[left] > data[right] ? right : left;
    }

    @Override
    public void printHeap() {
        System.out.print("nheap = ");
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
        int[] t = data.clone();
        Stack<Integer> stack = new Stack<>();
        int tSize = size;
        for (int i = 0; i < tSize; i++) {
            stack.push(delete(0));
        }
        data = t.clone();
        size = t.length - 1;
        return stack.peek();
    }

    @Override
    public int findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty.");
        }
        return data[0];
    }

    public static void main(String[] args) {
        MinTopHeapBinaryHeap minHeap = new MinTopHeapBinaryHeap(10);
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(11);
        minHeap.insert(12);
        minHeap.insert(13);
//        minHeap.insert(14);
//        maxHeap.insert(15);


//        minHeap.printHeap();
//        minHeap.delete(5);
//        minHeap.printHeap();
//        minHeap.delete(2);
//        minHeap.printHeap();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(minHeap.delete(0) + " ");
//        }
        System.out.println(minHeap.findMax());
        minHeap.printHeap();
        System.out.println(minHeap.findMin());
        minHeap.printHeap();
    }
}
