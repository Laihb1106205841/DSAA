package ADAS.Week8;

import java.util.Scanner;

public class Main {
    static final int MOD = 12345678;
    static int[][][][] dp = new int[102][102][32][32];
    static int [][] p = new int[1][1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(calculate(n, m, k));
    }

    public static int C(int n,int m) {
        int numerator = 1;
        int denominator = 1;

        m = Math.min(m, (n - m));
        for(int i = m;i > 0; i--) {
            numerator *= n;
            denominator *= i;
            n--;
        }
        return numerator / denominator;
    }



    public static int dp(int m, int n, int k) {
        // f:  i boys + j girls
        // p:  i boys + j girls - (k)

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
//                f[i][j] = C(i+j,j);
                p[i][j] = 1;
            }
        }

//        f[1][0] = 1;
//        f[0][1] = 1;
//        f[1][1] = 2;

        // 填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - j <= k) {
                    p[i][j] = (p[i - 1][j - 1] + p[i - 1][j] + p[i][j - 1]) % MOD;
                } else {
                    p[i][j] = p[i - 1][j] % MOD;
                }
            }
        }

        // 结果存储在dp[m][n]中
        return p[m][n];
    }

    public static int calculate(int n, int m, int k) {
        int ans = 0;
        // i  j  c  d      boy  girl  b-g  g-b    (min, max) <= k
        dp[0][0][0][0]=1;
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                for(int c=0; c<=k; c++){
                    for(int d=0; d<=k; d++){
                        //多了一个男生，所以新的情况是上一次多了男生的情况加上本次多了女生的情况
                        // max 是为了考虑最低的情况。相当于固定 i,j,c,d
                        dp [i+1][j][c+1][Math.max(d-1,0)] = (dp [i+1][j][c+1][Math.max(d-1,0)] + dp[i][j][c][d]) % MOD;

                        // 多了一个女生的情况
                        dp [i][j+1][Math.max(c-1,0)][d+1] = (dp [i][j+1][Math.max(c-1,0)][d+1] + dp[i][j][c][d]) % MOD;
                    }
                }
            }
        }


        // 考虑k，计算m,n的情况下所有的i,j情况
        for(int i=0;i<=k;i++){
            for(int j=0;j<=k;j++)
            {
                ans+= dp[m][n][i][j];
                ans%= MOD;
            }
        }
// reference:
//  https://www.luogu.com.cn/problem/solution/P2592

        return ans;
    }
}

