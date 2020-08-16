package com.hbq.aop;

public class MyCircularDeque {
    private Integer[] data;
    private int len;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        len = k;
        size = 0;
        data = new Integer[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == len) {
            return false;
        }
        size++;
        Integer[] dataC = new Integer[len];
        dataC[0] = value;
        System.arraycopy(data, 0, dataC, 1, len - 1);
        data = dataC;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == len) {
            return false;
        }
        data[size++] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (0 == size) {
            return false;
        }
        Integer[] dataC = new Integer[len];
        System.arraycopy(data, 1, dataC, 0, len - 1);
        data = dataC;
        if (size > 0) {
            size--;
        }
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (0 == size) {
            return false;
        }
        data[size - 1] = null;
        if (size > 0) {
            size--;
        }

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (0 == size) {
            return -1;
        }
        return data[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (0 == size) {
            return -1;
        }
        return data[size - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return 0 == size;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == len;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */