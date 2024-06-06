package ADAS.Week11;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostMaxFlow {

    static final int MX = 1000;
    static final int INF = 999999999;

    static int n, m, len = 0, st, ed;
    static int[] la = new int[MX];
    static int tou, wei;
    static int[] l = new int[MX];
    static Node[] a = new Node[MX];
    static Edge[] b = new Edge[MX * MX];

    static class Node {
        int d, v, f;
    }

    static class Edge {
        int x, y, c, d, f, gg;
    }

    static void ins(int x, int y, int c, int d) {
        len++;
        b[len] = new Edge();
        b[len].x = x;
        b[len].y = y;
        b[len].c = c;
        b[len].d = d;
        b[len].f = len + 1;
        b[len].gg = la[x];
        la[x] = len;
        len++;
        b[len] = new Edge();
        b[len].x = y;
        b[len].y = x;
        b[len].c = 0;
        b[len].d = -d;
        b[len].f = len - 1;
        b[len].gg = la[y];
        la[y] = len;
    }

    static boolean spfa() {
        Arrays.fill(a, new Node());
        for (int i = 1; i <= ed; i++) {
            a[i].v = 0;
            a[i].d = INF;
        }
        a[st].d = 0;
        a[st].v = 1;
        l[1] = st;
        tou = 1;
        wei = 2;

        while (tou != wei) {
            int x = l[tou];
            for (int i = la[x]; i > 0; i = b[i].gg) {
                int y = b[i].y;
                if (a[y].d > a[x].d + b[i].d && b[i].c > 0) {
                    a[y].d = a[x].d + b[i].d;
                    a[y].f = i;
                    if (a[y].v == 0) {
                        a[y].v = 1;
                        l[wei++] = y;
                        if (wei > ed) {
                            wei = 1;
                        }
                    }
                }
            }
            a[x].v = 0;
            tou++;
            if (tou > ed) {
                tou = 1;
            }
        }
        int x = ed;
        while (x != st) {
            int i = a[x].f;
            b[i].c -= 1;
            b[b[i].f].c += 1;
            x = b[i].x;
        }
        return a[ed].d != INF;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(la, 0);
        st = 1;
        ed = n * 2;

        ins(1, n + 1, INF, 0); // Splitting source
        ins(n, n * 2, INF, 0); // Splitting sink
        for (int i = 2; i < n; i++) {
            ins(i, i + n, 1, 0); // Splitting other nodes
        }

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            ins(x + n, y, 1, c);
        }

        int ans = 0, su = 0;
        while (spfa()) {
            ans++;
            su += a[ed].d;
        }
        System.out.printf("%d %d\n", ans, su);
        sc.close();
    }
}
