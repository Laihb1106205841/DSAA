package LeetcodePractice.String;

/**
 * @author admin
 */
public class Leetcode03 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){return s.length();}
        if(s.length()==2 && s.charAt(0)!=s.charAt(1)){return 2;}
        StringBuilder sb =new StringBuilder();
        int max = 1;

        //begin
        for (int i=0; i<s.length(); i++){
            //scan
            for(int j=i; j<s.length(); j++){
                if(sb.length()<=j){
                    boolean has = false;
                    for(int k =0; k<sb.length(); k++){
                        if (sb.charAt(k) == s.charAt(j)){
                            has = true;
                            break;
                        }
                    }
                    if (has){ break;}
                    else {
                        sb.append(s.charAt(j));
                    }
                }

            }
            int length = sb.length();
            max = Math.max(max,length);
            sb = new StringBuilder();
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "mwjwke";
        Leetcode03 a = new Leetcode03();
        int b = a.lengthOfLongestSubstring(s);
        System.out.println(b);
    }
}
