//package DSAA.Week15;
//import java.util.Arrays;
//
//public class AA {
//}
//
// class MinPriorityQueue {
//
//    private static final int DEFAULT_CAPACITY = 10;
//    private Node[] heap;
//    private int size;
//
//    public MinPriorityQueue() {
//        heap = new Node[DEFAULT_CAPACITY];
//        size = 0;
//    }
//
//    public void insert(Node node) {
//        ensureCapacity();
//        heap[size] = node;
//        heapifyUp(size);
//        size++;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public Node extractMin() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Priority queue is empty");
//        }
//
//        Node min = heap[0];
//        heap[0] = heap[size - 1];
//        size--;
//        heapifyDown(0);
//        return min;
//    }
//
//    public void decreaseKey(int vertex, long newWeight) {
//        int index = findIndex(vertex);
//        if (index != -1 && newWeight < heap[index].weight) {
//            heap[index].weight = newWeight;
//            heapifyUp(index);
//        }
//    }
//
//    private void heapifyUp(int index) {
//        while (index > 0) {
//            int parent = (index - 1) / 2;
//            if (heap[index].compareTo(heap[parent]) < 0) {
//                swap(index, parent);
//                index = parent;
//            } else {
//                break;
//            }
//        }
//    }
//
//    private void heapifyDown(int index) {
//        int leftChild = 2 * index + 1;
//        int rightChild = 2 * index + 2;
//        int smallest = index;
//
//        if (leftChild < size && heap[leftChild].compareTo(heap[smallest]) < 0) {
//            smallest = leftChild;
//        }
//
//        if (rightChild < size && heap[rightChild].compareTo(heap[smallest]) < 0) {
//            smallest = rightChild;
//        }
//
//        if (smallest != index) {
//            swap(index, smallest);
//            heapifyDown(smallest);
//        }
//    }
//
//    private int findIndex(int vertex) {
//        for (int i = 0; i < size; i++) {
//            if (heap[i].vertex == vertex) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private void swap(int i, int j) {
//        Node temp = heap[i];
//        heap[i] = heap[j];
//        heap[j] = temp;
//    }
//
//    private void ensureCapacity() {
//        if (size == heap.length) {
//            heap = Arrays.copyOf(heap, 2 * size);
//        }
//    }
//
//    public static class Node implements Comparable<Node> {
//        int vertex;
//        long weight;
//
//        public Node(int vertex, long weight) {
//            this.vertex = vertex;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Node other) {
//            return Long.compare(this.weight, other.weight);
//        }
//    }
//}
//
