package Week3;

import java.util.Scanner;

public class MaximumDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Time = scanner.nextInt();
        for (int j=0;j<Time;j++) {
        int N = scanner.nextInt();

        int maxDiff =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            if(a<min){min = a;}
            else {
                int diff = a-min;
                if(diff>maxDiff){
                    maxDiff = diff;
                }
            }
        }//get the number in

            System.out.print(maxDiff);
        }
    }
}
