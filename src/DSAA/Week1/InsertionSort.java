package DSAA.Week1;
import java.util.Scanner;

public class InsertionSort {
    public static void Insert(int[] array){
        for(int j=1;j<array.length; j++){
            int key = array[j];
            //insert

            int i =j-1;
            while(i>=0 && array[i]>key){
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1]=key;
        }
    }
    public static void BubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    swap(array,j-1,j);
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for(int i =0;i<N;i++){
            array[i] = scanner.nextInt();
        }//get the number in

        BubbleSort(array);

        for (int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }
}
