package DSAA.Week2;

import java.util.Scanner;

public class MatrixMultiply {
    public static int[][] Multiply(int[][] A, int[][] B){
        int length = A.length;
        int[][] C = new int[length][length];

        for(int i = 0;i<length;i++){
            for(int j = 0; j<length;j++){
                C[i][j] = 0;
                for(int k = 0;k< length;k++){
                    C[i][j] = C[i][j] + A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] A = new int[N][N];
        for(int i =0;i<N;i++){
            for (int j=0;j<N;j++) {
                A[i][j] = scanner.nextInt();
            }
        }//get the number in

        int[][] B = new int[N][N];
        for(int i =0;i<N;i++){
            for (int j=0;j<N;j++) {
                B[i][j] = scanner.nextInt();
            }
        }//get the number in

        int[][]C;
        C = Multiply(A,B);
        for(int i =0;i<N;i++){
            for (int j=0;j<N;j++) {
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }//get the number in
    }
}
