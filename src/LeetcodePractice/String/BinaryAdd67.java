package LeetcodePractice.String;

import java.util.Arrays;

/**
 * @author admin
 */
public class BinaryAdd67 {
    public String addBinary(String a, String b) {
        int alen = a.length()-1;
        int blen = b.length()-1;
        int carry =0;
        StringBuilder sb =new StringBuilder();
        while(alen>=0 || blen>=0||carry!=0){
            if (alen >= 0) {
                carry += a.charAt(alen) - '0';
                alen--;
            }
            if (blen >= 0) {
                carry += b.charAt(blen) - '0';
                blen--;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

}
