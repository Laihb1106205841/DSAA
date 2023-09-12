package Week1;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for(int i =0;i<N;i++){
            array[i] = scanner.nextInt();
        }//get the number in

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

        for (int i=0;i<N;i++){
            System.out.print(array[i]+" ");
        }
    }
}
