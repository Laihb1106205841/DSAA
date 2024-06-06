package ADAS.Week8;

import java.util.Scanner;

public class CompleteKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W = scanner.nextInt();

        int[] weight = new int[N];
        int[] value = new int[N];
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = scanner.nextInt();
            value[i]  = scanner.nextInt();
            number[i] = scanner.nextInt();
        }

        int maxValue = completeKnapsack(N, W, value, weight, number);

        System.out.println(maxValue);

    }

    public static int completeKnapsack(int N, int W, int[] value, int[] weight, int[] number) {
        int[] dp = new int[W + 1];//容量

        for (int i = 0; i < N; i++) {
            for (int j = W; j >= weight[i]; j--) {
                for (int k = 1; k <= number[i] && k * weight[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);// 1个1个拿
                }
            }
        }

        return dp[W];
    }


}

