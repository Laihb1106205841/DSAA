package ADAS.Week9;

import java.util.Scanner;

public class LevenshteinDistance {

    public static int levenshteinDistance(String s1, String s2, int k) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        if(s1.length()<s2.length()){
            return levenshteinDistance(s2, s1, k);
        }

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i*k; // 从s1 变成空字符串的代价
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j*k; // 从s2 变成空字符串的代价
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost;
                if(s1.charAt(i-1) == ' '){
                    if(s2.charAt(j-1) == ' '){
                        cost = 0;
                    }else {
                        cost = k;
                    }
                }else{
                    if(s2.charAt(j-1) == ' '){
                        cost = k;
                    }
                    else {
                        cost = Math.abs(s1.charAt(i - 1) - s2.charAt(j - 1));
                    }
                }

                // 在 字符串s1的前i-1个字符 与 字符串s2的前j个字符 完全相同的基础上, 进行一次删除操作
                int costBy_Insert = dp[i - 1][j] + k;
                // 在 字符串A的前i个字符 与 字符串B的前j-1个字符 完全相同的基础上, 进行一次插入操作
                int cosBy_Delete = dp[i][j - 1] + k;

                int previous = Math.min(costBy_Insert,cosBy_Delete);

                dp[i][j] = Math.min(previous, dp[i - 1][j - 1] + cost);// replace
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static String expand(String s){
        StringBuilder expanded = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            expanded.append(s.charAt(i));
            if (i <= s.length() - 1) {
                expanded.append(' ');
            }
        }

        return expanded.toString();
    }
    public static String[] expandAndAlign(String s1, String s2) {
        // 展开两个字符串
        String expanded1 = expand(s1);
        String expanded2 = expand(s2);

        int length1 = expanded1.length();
        int length2 = expanded2.length();

        int difference = Math.abs(length1 - length2);

        // 如果第一个字符串比较短，就在后面添加空格
        if (length1 < length2) {
            for (int i = 0; i < difference; i++) {
                expanded1 += " ";
            }
        } else if (length2 < length1) {
            // 如果第二个字符串比较短，就在后面添加空格
            for (int i = 0; i < difference; i++) {
                expanded2 += " ";
            }
        }

        String[] a = new String[2];
        a[0] = expanded1;
        a[1] = expanded2;

        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int k = scan.nextInt();

//        String[] a = expandAndAlign(s1,s2);
        System.out.println(levenshteinDistance(s1, s2, k));
    }
}

