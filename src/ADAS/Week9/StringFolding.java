package ADAS.Week9;

import java.util.Scanner;

public class StringFolding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int n = input.length();

        int[][] f = new int[n][n];
        int[] a = new int[105];
        char[] s = input.toCharArray();

        for (int i = 1; i <= 9; i++) {
            a[i] = 1;
        }
        for (int i = 10; i <= 99; i++) {
            a[i] = 2;
        }
        a[100] = 3;

        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0, j = i + l - 1; j < n; i++, j++) {
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                }

                for (int k = 2; k <= l; k++) {
                    if (l % k == 0 && check(i, j, k)) {
                        f[i][j] = Math.min(f[i][j], f[i][i + l / k - 1] + 2 + a[k]);
                    }
                }
            }
        }

        System.out.println(f[0][n - 1]);
    }

    private static boolean check(int i, int j, int k) {
//        int len = j - i + 1;
//        int c = len / k;
//        for (int l = i; l <= i + c - 1; l++) {
//            char now = s[l];
//            for (int o = 1; o < k; o++) {
//                if (now != s[l + o * c]) {
//                    return false;
//                }
//            }
//        }
        return true;
    }
}
