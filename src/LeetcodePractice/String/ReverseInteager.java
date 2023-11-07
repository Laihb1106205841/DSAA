package LeetcodePractice.String;

/**
 * @author admin
 */
public class ReverseInteager {
    public int reverse(int x) {
        String x1 = Integer.toString(x);
        StringBuilder x2 = new StringBuilder();
        for (int i=x1.length();i>0;i--) {
            if (x1.charAt(i - 1) != '-') {
                x2.append(x1.charAt(i - 1));
            }
        }
        if(x<0){x2.insert(0,'-');}
        try{
            return Integer.parseInt(x2.toString());}
        catch (NumberFormatException e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        ReverseInteager a = new ReverseInteager();
        a.reverse(1534236469);
    }
}
