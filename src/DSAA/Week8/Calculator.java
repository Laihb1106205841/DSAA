package DSAA.Week8;

import java.util.Scanner;


public class Calculator {
    public int[] st;
    public boolean bracketsIsNull;
    public boolean brackets;
    int pointer;

    public Calculator(){
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

    public int pop2st(){
        int result;
        result = st[pointer-1];
        st[pointer] = 0;
        pointer--;
        if(pointer == 0){
            bracketsIsNull = true;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // next line
        String[] items = scanner.nextLine().split(" ");

        Calculator st = new Calculator();

        for (String item : items) {
            //numbers
            if (item.matches("-?\\d+")) {
                st.push2st(Integer.parseInt(item));
            }
            //operator
            else {
                int operand1 = st.pop2st();
                int operand2 = st.pop2st();
                switch (item) {
                    case "+" -> st.push2st(operand1 + operand2);
                    case "-" -> st.push2st(operand2 - operand1);
                    case "*" -> st.push2st(operand1 * operand2);
                    case "/" -> st.push2st(operand2 / operand1);
                }
            }
        }

        int result = st.pop2st();
        System.out.println(result);


    }

}





