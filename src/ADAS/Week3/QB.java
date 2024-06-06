package ADAS.Week3;

import java.util.Scanner;

public class QB {
    public static int CalculateMaximumIncome(int N, int[][] Orders){
        int income = 0;
        int creativity = 0;
        int cars = 0;





        return income;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] Orders = new int[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                Orders[i][j] = scan.nextInt();
            }
        }
        int income = CalculateMaximumIncome(N,Orders);
        System.out.println(income);
    }
}
