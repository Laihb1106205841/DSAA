package ADAS.Week9;

import java.util.*;

public class function {
    static int[][] f = new int[105][105];
    static int[] sz = new int[105];

    // 检查s中是否包含长度为len的连续子串，且这些子串都相等
    public static boolean check(String s, int l, int r, int len) {
        for (int i = l; i <= l + len - 1; i++) {
            for (int j = i; j <= r; j += len) {
                if (s.charAt(j) != s.charAt(i)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }

        for (int i = 1; i <= 100; i++) {
            if (i <= 9){
                sz[i] = 1;
            }
            else if (i <= 99){
                sz[i] = 2;
            }
            else{
                sz[i] = 3;
            }
        }

        for (int l = 1; l <= n; l++) {
            for (int i = 0, j = i + l - 1; j < n; i++, j++) {
                for (int k = i; k < j; k++) {

                    // DP  要么是不变，要么是两个子情况
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);

                    int len = k - i + 1;

                    if (l % len != 0){
                        continue;
                    }
                    if (check(s, i, j, len)){
                        f[i][j] = Math.min(f[i][j], sz[l / len] + f[i][k] + 2);
                    }
                }
            }
        }
        System.out.println(f[0][n - 1]);
    }


}
