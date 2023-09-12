package Week1;

import java.util.Scanner;

public class SelectionSort {
    public static int[] SelectionSort(int[] A){
        int N = A.length;
        for(int j=0;j<N;j++){
            int smallest = j;
            for(int i=j+1;i<N;i++){
                if(A[i]<A[smallest]){smallest = i;}
            }

            int temp = A[smallest];
            A[smallest] = A[j];
            A[j] = temp;//swap
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for(int i =0;i<N;i++){
            array[i] = scanner.nextInt();
        }//get the number in
        int[] m = SelectionSort(array);
        for (int i=0;i<m.length;i++){
            System.out.print(m[i]+" ");
        }
    }

}
