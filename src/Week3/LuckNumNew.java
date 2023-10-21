package Week3;


import java.util.Scanner;

public class LuckNumNew {
    public static boolean isLuck(long a){
        String m = Long.toString(a);
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
            long l = Long.parseLong(scanner.next());
            long r = Long.parseLong(scanner.next());
            long count = l; // initial count

            int number = 0;
            while (count<= r) {

                if(isLuck(count)){number+=1;}
                else {
                    String m = Long.toString(count);
                    int pos = m.indexOf("2");

                }
                // add counter
                count +=1;
            }


            System.out.println(number);
        }
    }
}
