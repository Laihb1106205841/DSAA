package ADAS.Week1;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        System.out.println(get(n, k));
    }
    public static int get(int n,int k){
        if(n==1 && k==1){return 1;}
        if(2*k>n+1){return get(n,n-k+1);}
        else {return 2*k;}

    }
}
