package ADAS.Week3;

import java.util.Arrays;

public class MinimumPunishmentAmount {
    public static int calculateMinimumPunishment(int t, int[] deadlines, int[] punishments) {
        int n = deadlines.length;

        // 创建一个长度为t的数组来保存每个时间段的最小惩罚金额
        int[] dp = new int[t + 1];

        // 对dp数组进行初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 动态规划计算最小惩罚金额
        for (int i = 0; i < n; i++) {
            for (int j = t; j >= deadlines[i]; j--) {
                // 在截止时间之前完成比赛，更新dp数组
                if (dp[j - deadlines[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - deadlines[i]] + punishments[i]);
                }
            }
        }

        // 返回dp数组中的最小惩罚金额
        return dp[t];
    }

    public static void main(String[] args) {
        int t = 5;
        int[] deadlines = {2, 3, 1, 4, 2};
        int[] punishments = {10, 8, 12, 6, 9};

        int minimumPunishment = calculateMinimumPunishment(t, deadlines, punishments);
        System.out.println("Minimum Punishment Amount: $" + minimumPunishment);
    }
}

