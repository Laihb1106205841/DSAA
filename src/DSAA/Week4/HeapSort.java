package DSAA.Week4;

import java.util.Scanner;

public class HeapSort {

    public static void Max_Heapify(int[] array,int i,int HeapSize){
        int l = 2*i;   //left i
        int r = 2*i+1; //right i
        int largest = i-1;
        if(l <= HeapSize ) {
            if(array[l-1]> array[largest])
            {largest =l-1;}
        }
        if(r <= HeapSize)
        {
            if(array[r-1] > array[largest])
                {largest = r-1;}
        }

        if(largest != i-1){ //swap and into the leaves
            int tmp = array[largest];
            array[largest] = array[i-1];
            array[i-1] = tmp;

            Max_Heapify(array,largest+1,HeapSize);
        }

    }
    public static void BuildMaxHeap(int[] array,int HeapSize){
        for(int m = HeapSize/2+1; m>0; m--){ //fix m
            Max_Heapify(array,m,HeapSize);
        }
    }

    public static void heapSort(int[] array){
        int HeapSize = array.length;
        BuildMaxHeap(array,array.length);

        for(int i =array.length-1;i>0;i--){
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            HeapSize -=1;
            Max_Heapify(array,1,HeapSize);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }//get the number in
        heapSort(array);
        for (int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }
}
