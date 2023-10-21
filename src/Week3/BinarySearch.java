package Week3;

import java.util.Scanner;

public class BinarySearch {
    public static boolean binarySearch(int[] array,int test,int low,int high){
        if(array.length==1){return (array[0]==test);}

        if((high-low)==1&&array[high]!=test&&array[low]!=test){return false;}
        int halfL =(low+high)>>1;
        if(array[halfL] == test){return true;}
        else if(array[halfL] > test){return binarySearch(array,test,low,halfL);}
        else {return binarySearch(array,test,halfL,high);}
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i =0;i<T;i++){
            int N = scanner.nextInt();
            int[] array = new int[N];
            int find = scanner.nextInt();

            for (int j = 0; j < N; j++) {
                array[j] = scanner.nextInt();
            }//get the number in

            boolean M = binarySearch(array,find,0,array.length-1);
            if(M){System.out.println("YES");}
            else {System.out.println("NO");}

        }
    }
}
