package DSAA.Week3;

import java.math.BigInteger;

import java.util.Scanner;

public class luckyNum {
    public static boolean isLuck(BigInteger a){
        String m = a.toString();
        if(m.contains("2") || m.contains("3") || m.contains("4") || m.contains("5") ||
        m.contains("7") ){return false;}
        StringBuilder n = new StringBuilder();
        char[] mm = m.toCharArray();
        for(int i =mm.length-1;i>-1;i--){
            if(mm[i] == '6'){n.append('9');}
            else if(mm[i] == '9'){n.append('6');}
            else {n.append(mm[i]);}
        }
        String modi = n.toString();
        return m.equals(modi);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            BigInteger l = new BigInteger(scanner.next());
            BigInteger r = new BigInteger(scanner.next());
            BigInteger count = BigInteger.ZERO; // initial count
            BigInteger cha = r.subtract(l).add(BigInteger.ONE);

            int number = 0;
            while (count.compareTo(cha) < 0) {

                if(isLuck(count.add(l))){number+=1;};
                // 增加计数器
                count = count.add(BigInteger.ONE);
            }


            System.out.println(number);
        }
    }
}
