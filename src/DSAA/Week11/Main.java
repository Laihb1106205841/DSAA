package DSAA.Week11;

import java.util.Scanner;

public class Main {
    public int count[];
    public int RodLength;
    public int BestCase;
    public int How;
    public int Memorize_Cut_Rod(int[] prices, int RodLength){
        int[] MemoryPrice = new int[RodLength+1];
        for(int k=0;k<RodLength+1;k++){
            MemoryPrice[k] = -2147;
        }
        int k = 0;
        return Memorize_Cut_Rod_AUX(k,prices, RodLength,MemoryPrice);
    }
    private int Memorize_Cut_Rod_AUX(int k,int[] prices, int Length,int[] MemoryPrice){

        if(MemoryPrice[Length]>=0){return MemoryPrice[Length];}
        if(Length==0){
            return 0;}
        else {
            for(int i=1;i<Length+1;i++){
                k = FindMax(k,prices[i]+Memorize_Cut_Rod_AUX(k,prices,Length-i,MemoryPrice));
            }
            MemoryPrice[Length] = k;
        }
        return k;
    }
    private int Memorize_Cut_Rod_AUX(int k,int[] prices, int Length,int[] MemoryPrice,int c){

        if(MemoryPrice[Length]>=0){return MemoryPrice[Length];}
        if(Length==0){
            return 0;}
        else {
            for(int i=1;i<Length+1;i++){
                k = FindMax(k,prices[i]+Memorize_Cut_Rod_AUX(k,prices,Length-i,MemoryPrice,c)-c);
            }
            MemoryPrice[Length] = k;
        }
        return k;
    }
    private int FindMax(int a,int b){
        if(a>=b){return a;}else {return b;}
    }

    private int[] Bottom_Up_Cut_Rod(int Length,int[] prices){
        int[] r = new int[Length];
        int[] s = new int[Length];
        r[0] = 0;
        for(int i=0;i<Length;i++){
            int k = -2147;
            for(int j=0;j<i;j++){
                if(k<prices[j]+r[i-j]){
                    k=prices[j]+r[i-j];
                    s[i] = j;
                }
                r[i] = k;
            }
        }
        int[] ans = new int[2*Length];
        for(int i=0;i<Length;i++){
            ans[i] = r[i];
            ans[i+Length] = s[i];
        }
        return ans;
    }

    public static void extendedBottomUpCutRod(int[] p, int n, int[] r, int[] s) {
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = -10000;
            for (int i = 1; i <= j; i++) {
                if (q < p[i] + r[j - i]) {
                    q = p[i] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
    }
    private static void printCutRodSolution(int[] s, int n) {
        int count = 0;
        int n1 = n;
        while (n1 > 0) {
//            System.out.print((int) s[n] + " ");
            n1 -= s[n1];
            count++;
        }
        System.out.println(count);
        while (n > 0) {
            System.out.print((int) s[n] + " ");
            n -= s[n];
        }
    }

    public Main(){
        Scanner scan = new Scanner(System.in);
        this.RodLength = scan.nextInt();
        int[] prices = new int[RodLength+1];

        for(int i=1;i<RodLength+1;i++){
            prices[i] = scan.nextInt();
        }
        scan.close();

        int n = prices.length - 1; // length of the rod

        int[] r = new int[n + 1];//store the
        int[] s = new int[n + 1];
        extendedBottomUpCutRod(prices,n,r,s);
        System.out.println(r[n]);

        printCutRodSolution(s, n);
    }


    public static void main(String[] args) {
        Main m = new Main();
    }
}
