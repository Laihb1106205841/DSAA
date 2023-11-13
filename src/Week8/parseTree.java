package Week8;

import java.util.Scanner;


public class parseTree {
    public int[] st;
    public boolean bracketsIsNull;
    public boolean brackets;
    int pointer;

    public parseTree(){
        st = new int[10];
        pointer =0;
        bracketsIsNull = true;
        brackets       = true;
    }
    public void push2st(int val){
        st[pointer] = val;
        if(pointer == st.length-1){
            int[] st2 = new int[st.length+10];
            System.arraycopy(st, 0, st2, 0, st.length);
            st = st2;
        }
        pointer++;
        bracketsIsNull = false;
    }

    public void pop2st(int exam){
        if(bracketsIsNull){
            brackets=false;
            return;
        }
        if(exam == st[pointer-1]){
            st[pointer] = 0;
            pointer--;
            if(pointer == 0){
                bracketsIsNull = true;
            }
        }
        else brackets=false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            parseTree pr = new parseTree();
            String a = scanner.next();
            char[] cc = a.toCharArray();
            for (char c : cc) {
                if (pr.brackets) {
                    switch (c) {
                        case '(' -> pr.push2st(1);
                        case ')' -> pr.pop2st(1);
                        case '[' -> pr.push2st(2);
                        case ']' -> pr.pop2st(2);
                        case '{' -> pr.push2st(3);
                        case '}' -> pr.pop2st(3);
                    }
                }
            }
            if(pr.brackets && pr.pointer==0){System.out.println("Yes");}
            else {System.out.println("No");}

        }
    }
}
