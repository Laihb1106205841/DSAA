package Week3;

import java.util.Scanner;
import java.math.BigInteger;

public class VeryBig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            float a = scanner.nextFloat();
            a = a*85/100;
            System.out.printf("%.2f\n",a);
        }
    }
}

