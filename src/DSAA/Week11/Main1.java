package DSAA.Week11;

public class Main1 {
    static double infinity = 1e+16;

    public static void main(String[] args) {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30,45,23,34,12}; // 示例输入数组
        int n = p.length - 1; // 钢条长度

        int[] r = new int[n + 1];
        int[] s = new int[n + 1];

        extendedBottomUpCutRod(p, n, r, s);

        System.out.println("Optimal value: " + r[n]);
        System.out.print("Cut positions: ");
        printCutRodSolution(s, n);
    }

    static void extendedBottomUpCutRod(int[] price, int n, int[] Maxvalue, int[] CutPlace) {
        Maxvalue[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = -10000;
            for (int i = 1; i <= j; i++) {
                if (q < price[i] + Maxvalue[j - i]) {
                    q = price[i] + Maxvalue[j - i];//p[i]+Max()
                    CutPlace[j] = i;
                }
            }
            Maxvalue[j] = q;
        }
    }

    static void printCutRodSolution(int[] s, int n) {
        while (n > 0) {
            System.out.print((int) s[n] + " ");
            n -= s[n];
        }
    }
}
