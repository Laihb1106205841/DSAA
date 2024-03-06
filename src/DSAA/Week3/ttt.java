package DSAA.Week3;

import java.util.Scanner;

public class ttt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int Xmin = scanner.nextInt();
            int Xmax = scanner.nextInt();
            int Ymin = scanner.nextInt();
            int Ymax = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            if(X<=Xmax && X>=Xmin && Y<=Ymax&&Y>=Ymin){System.out.println("Yes");}
            else {System.out.println("No");}
        }
    }
}
