package ADAS.Week1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int n = scan.nextInt();
            System.out.println(decide(n));
        }
    }
    public static String decide(int n){
        if(n%6==0){return "Bob";}
        return "Alice";
    }
}
