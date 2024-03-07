package ADAS.Week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxHeap {
    private ArrayList<Integer> heap;
    private Map<Integer, Integer> indexMap;

    public MaxHeap() {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    // 插入元素
    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        indexMap.put(value, index);
        heapifyUp(index);
    }

    // 弹出最大值，并返回其是第几个输入的
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap.get(0);
        int lastIndex = heap.size() - 1;
        int lastValue = heap.remove(lastIndex);
        indexMap.remove(max);
        if (lastIndex > 0) {
            heap.set(0, lastValue);
            indexMap.put(lastValue, 0);
            heapifyDown(0);
        }
        return max;
    }

    // 上浮操作
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap.get(parent) < heap.get(index)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // 下沉操作
    private void heapifyDown(int index) {
        int leftChild;
        int rightChild;
        int maxChild;

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            maxChild = index;

            if (leftChild < heap.size() && heap.get(leftChild) > heap.get(maxChild)) {
                maxChild = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild) > heap.get(maxChild)) {
                maxChild = rightChild;
            }

            if (maxChild != index) {
                swap(index, maxChild);
                indexMap.put(heap.get(index), index);
                indexMap.put(heap.get(maxChild), maxChild);
                index = maxChild;
            } else {
                break;
            }
        }
    }

    // 交换元素
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 获取堆的大小
    public int size() {
        return heap.size();
    }

    // 获取最大值在堆中是第几个输入的
    public int getMaxIndex(int max) {
        return indexMap.get(max) + 1;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(3);

        System.out.println("Max value: " + maxHeap.extractMax() + ", entered as: " + maxHeap.getMaxIndex(4));
    }
}













// 草稿

//    class collage_in_student{
//        int collage_index;
//        int collage_score_in_student_mind;
//        public collage_in_student(int collage_index,int collage_score_in_student_mind){
//            this.collage_score_in_student_mind=collage_score_in_student_mind;
//            this.collage_index = collage_index;
//        }
//    }
//
//    class Student {
//        PriorityQueue<collage_in_student> heap = new PriorityQueue<collage_in_student>(
//                new Comparator<collage_in_student>() {
//            @Override
//            public int compare(collage_in_student o1, collage_in_student o2) {
//                return o1.collage_score_in_student_mind - o2.collage_score_in_student_mind;
//            }
//        });
//
//        public Student(int[] your_School_list){
//            for(int i=0;i<your_School_list.length;i++){
//                if(your_School_list[i]<0){
//                    continue;
//                }else {
//                    collage_in_student collage = new collage_in_student(i,your_School_list[i]);
//                    heap.add(collage);
//                }
//            }
//        }
//        public collage_in_student GetNewSchool(){
//            return heap.poll();
//        }
//    }
