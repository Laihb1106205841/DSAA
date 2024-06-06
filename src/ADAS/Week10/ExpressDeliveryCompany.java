package ADAS.Week10;

//https://www.luogu.com.cn/problem/solution/P3354 学习，书写
import java.util.*;

public class ExpressDeliveryCompany {
    static int num = 200;
    static int[] son = new int[num];
    static int[] bro = new int[num];
    static int[] w = new int[num];
    static int[] v = new int[num];
    static int[] d = new int[num];
    static int[][] dis = new int[num][num];
    static int n_farmer, k_collector;
    static int[][][] f = new int[num][num][num];

    public static void dfs(int u, int liml) {
        int s = son[u];
        int b = bro[u];
        for(int l = 1; l <= liml; l++) {
            dis[u][l] = dis[v[u]][l - 1] + d[u];
        }

        if(s != 0){ dfs(s, liml + 1);}
        if(b != 0){ dfs(b, liml);}
        for(int i = 0; i <= n_farmer; i++) {
            for(int j = 0; j <= n_farmer - i; j++) {
                for(int l = 1; l <= liml; l++) {
                    // 状态更新：选择一个新的collector
                    f[u][i + j][l] = Math.min(f[u][i + j][l],         f[s][i][l + 1] + f[b][j][l] + w[u] * dis[u][l]);
                    f[u][i + j + 1][l] = Math.min(f[u][i + j + 1][l], f[s][i][1] + f[b][j][l]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n_farmer = sc.nextInt();
        k_collector = sc.nextInt();

        // 0: center
        for(int i = 1; i <= n_farmer; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
            d[i] = sc.nextInt();
            bro[i] = son[v[i]];
            son[v[i]] = i;
        }

        for(int[][] subArray : f) {
            for(int[] arr : subArray) {
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i <= n_farmer; i++) {
            for(int j = 0; j <= n_farmer; j++) {
                f[0][i][j] = 0;
            }
        }

        dfs(son[0], 1);

        System.out.println(f[son[0]][k_collector][1]);
    }
}

