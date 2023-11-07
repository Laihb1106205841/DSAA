package Week8;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // next line
        String[] items = scanner.nextLine().split(" ");

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<items.length;i++){
            //numbers
            if(items[i].matches("-?\\d+")){
                stack.push(Integer.parseInt(items[i]));
            }
            //operator
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (items[i]){
                    case "+":
                        stack.push(operand1+operand2);
                        break;

                    case "-":
                        stack.push(operand2-operand1);
                        break;

                    case "*":
                        stack.push(operand1*operand2);
                        break;

                    case "/":
                        stack.push(operand2/operand1);
                        break;
                }
            }
        }

        int result = stack.pop();
        System.out.println(result);


    }
}
