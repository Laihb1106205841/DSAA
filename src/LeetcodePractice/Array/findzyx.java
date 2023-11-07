package LeetcodePractice.Array;

public class findzyx {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        ans[0] = 1000000;
        int[] pos = new int[2];
        for (int a=1; a<= Math.sqrt(area); a++){
            if(area%a ==0){
                pos[1] = a;
                pos[0] = area/a;
                if(pos[0]-pos[1] < ans[0]-ans[1] ){
                    ans[0] = pos[0];
                    ans[1] = pos[1];
                }
            }

        }
        return ans;
    }
}
