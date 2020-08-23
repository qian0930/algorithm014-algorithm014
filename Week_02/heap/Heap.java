package com.hbq.aop.datastructure;

public interface Heap {
    boolean isEmpty();

    boolean isFull();

    /**
     * node's parent node's index
     *
     * @param i
     * @return
     */
    int parent(int i);

    /**
     * node's child index
     *
     * @param i current node index
     * @param k 1 left child, 2 right child
     * @return
     */
    int kthChild(int i, int k);

    void insert(int x);

    /**
     * delete element at index i
     *
     * @param i
     * @return
     */
    int delete(int i);

    void heapifyUp(int i);

    void heapifyDown(int i);

    int maxChild(int i);

    int minChild(int i);

    void printHeap();

    int findMax();

    int findMin();
}
