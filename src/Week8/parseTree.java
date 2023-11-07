package Week8;

import java.util.Scanner;
import java.util.Stack;

public class parseTree {
    public Stack<Integer> st;
    public boolean brackets;

    public parseTree(){
        st = new Stack<Integer>();
        brackets = true;
    }
    public void push2st(int val){
        st.push(val);
    }
    public void pop2st(int examime){
        if(st.empty()){
            brackets=false;
            return;
        }
        if(examime == st.lastElement()){
            st.pop();
        }
        else brackets=false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            parseTree pr = new parseTree();
            String a = scanner.next();
            char[] cc = a.toCharArray();
            for(int i=0;i<cc.length;i++){
                if(pr.brackets){
                    switch (cc[i]){
                        case '(':   pr.push2st(1);break;
                        case ')':   pr.pop2st(1);break;
                        case '[':   pr.push2st(2);break;
                        case ']':   pr.pop2st(2);break;
                        case '{':   pr.push2st(3);break;
                        case '}':   pr.pop2st(3);break;
                    }
                }
            }
            if(pr.brackets && pr.st.empty()){System.out.println("Yes");}
            else {System.out.println("No");}

        }
    }
}
