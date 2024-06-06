package ADAS.Week12;

// Framework: None
// Technology stack: None

//https://www.luogu.com.cn/problem/P5192

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A {
    public static final int N = 314514;
    static int[] val = new int[N];
    static int[] in = new int[N];

    static final int INF = 2147483647;

    static int n, m;

    static int cnt, all;
    static int[] head = new int[N];
    static int[] to = new int[N];
    static int[] nxt = new int[N];

    static int tot;
    static int S_start, T_end, s, t;
    static int[] d = new int[N];

    public static void add(int u, int v, int weight) {
        to[++tot] = v;
        nxt[tot] = head[u];

        val[tot] = weight;

        head[u] = tot;

        to[++tot] = u;
        nxt[tot] = head[v];
        head[v] = tot;
        val[tot] = 0;
    }

    public static void addc(int u, int v, int l, int r) {
        to[++tot] = v;
        nxt[tot] = head[u];
        head[u] = tot;
        val[tot] = r-l;
        to[++tot] = u;
        nxt[tot] = head[v];
        head[v] = tot;
        val[tot] = 0;

        in[u] -= l;
        in[v] += l;
    }

    public static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        Arrays.fill(d, -1);
        d[s] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = head[x]; i > 0; i = nxt[i]) {
                if (val[i] == 0) continue;
                int y = to[i];
                if (d[y] == -1) {
                    d[y] = d[x] + 1;
                    if (y == t){
                        return true;
                    }
                    q.add(y);
                }
            }
        }
        return false;
    }

    public static int dfs(int x, int a) {
        if (a == 0 || x == t) return a;
        int res = a;
        for (int i = head[x]; i > 0; i = nxt[i]) {
            int y = to[i];
            if (val[i] > 0 && d[x] + 1 == d[y]) {
                int tmp = dfs(y, Math.min(val[i], res));
                res -= tmp;
                val[i] -= tmp;
                val[i ^ 1] += tmp;
                if (res == 0) return a;
            }
        }
        if (a == res){
            d[x] = -1;
        }
        return a - res;
    }

    public static int dinic() {
        int flow = 0;
        while (bfs()){
            flow += dfs(s, INF);
        }
        return flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();

            tot = 1;
            cnt = 0;
            s = N - 6;
            t = N - 7;
            S_start = n + m + 1;
            T_end = n + m + 2;

            all = 0;
            Arrays.fill(head, 0);
            Arrays.fill(in, 0);


            for (int i = 1; i <= m; i++) {
                int g = sc.nextInt();
                addc(i + n, T_end, g, INF);
            }

            for (int i = 1; i <= n; i++) {
                int c = sc.nextInt();
                int d = sc.nextInt();
                add(S_start, i, d);
                for (int j = 1; j <= c; j++) {
                    int t = sc.nextInt();
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    addc(i, n + t + 1, l, r);
                }
            }

            for (int i = 1; i <= m + n + 2; i++) {
                if (in[i] > 0) {
                    add(s, i, in[i]);
                    all += in[i];
                }
                if (in[i] < 0) add(i, t, -in[i]);
            }

            add(T_end, S_start, INF);

            if (all <= dinic()) {
                all = val[tot];
                val[tot] = val[tot - 1] = 0;
                s = S_start;
                t = T_end;
                System.out.println(dinic() + all);

            } else {
                System.out.println("-1");
            }
        }


            sc.close();
        }
}