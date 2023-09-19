package Week1;

import java.util.Scanner;

public class test {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int n =0;
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            n+=1;
            double m = a* Math.log10(2);
            int ans = (int) (m/1);
            //Add your code
            System.out.println("Case #"+n+": "+ans);
        }

    }
}
