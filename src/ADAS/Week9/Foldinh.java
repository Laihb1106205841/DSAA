package ADAS.Week9;
import java.util.Scanner;

public class Foldinh {

    // f
    private static int[][] f = new int[101][101];
    private static char[] a = new char[101];

    // 循环的长度
    private static int cal(int x) {
//        int ans = 0;
//        while (x > 0) {
//            ++ans;
//            x /= 10;
//        }
        return x-1;
    }

    private static boolean check(int s, int l, int c) {
        if (l % c != 0) return false;
        for (int i = s + c; i < s + l; ++i) {
            if (a[i] != a[(i - s) % c + s]) {
                return false;
            }
        }
        return true;
    }

    private static int dp(int l, int r) {
        if (f[l][r] < 1e7) return f[l][r]; // 记忆化
        if (r <= l) return 1;
        f[l][r] = r - l + 1;

        for (int k = l; k <= r; ++k) {
            f[l][r] = Math.min(f[l][r], dp(l, k) + dp(k + 1, r));
        }
        int tmp = (r - l + 1) / 2;

        // 折叠
        for (int len = tmp; len >= 1; --len) { // 只有小于等于区间长度才有可能形成循环节
            if (check(l, r - l + 1, len)) {
                if(l == 0){
                    f[l][r] = Math.min(f[l][r], f[l][l + len - 1]  + cal((r - l + 1) / len));
                }else {
                    f[l][r] = Math.min(f[l][r], f[l][l + len - 1] + 1 + cal((r - l + 1) / len));
                }

            }
        }
        return f[l][r];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine().toCharArray();

        int lena = a.length;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < lena; i++) {
            f[i][i] = 1;
        }
        System.out.println(dp(0, lena - 1));
    }
}
