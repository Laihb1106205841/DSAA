package Week8;

public class doublepointGUPIAO {
    public int maxProfit(int[] prices) {
        int slow=0,fast =0;
        int max =0;
        while (fast<prices.length){
            if(prices[fast]<prices[slow]){
                slow = fast;
            }
            else {
            max = Math.max(prices[fast] - prices[slow], max);
            }
            fast++;
        }
        return max;
    }
    public int maxProfit2(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {  //
                ans += (arr[i] - arr[i-1]);
            }
        }
        return ans;
    }
}
