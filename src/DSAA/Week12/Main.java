package DSAA.Week12;

import java.util.Scanner;

public class Main {

    public static int Recursive_Activity_Reclusive(int[] S, int[] F,int k,int n){
        int m = k+1;
        while (m<=n && S[m]<F[k]){
            m+=1;
        }
        if(m<=n){return (1+Recursive_Activity_Reclusive(S,F,m,n));}
        else return 1;
    }
    public static int Recursive_Activity_Selector(int[] S, int[] F,int n){
        int count = 1;
        int k = 0;
        for(int i=0;i<n+1;i++){
            if(S[i]>=F[k]){
                count += 1;
                k = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] S = new int[N];
        int[] F = new int[N];
        for(int i=0;i<N;i++){
            S[i] = scan.nextInt();
        }
        for(int i=0;i<N;i++){
            F[i] = scan.nextInt();
        }
        int MaxSize = Recursive_Activity_Selector(S,F,N-1);
        System.out.println(MaxSize);
    }
}
