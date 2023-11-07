package Week8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean isEmpty = true;

        for (int i = 0; i < q; i++) {
            int request = scanner.nextInt();
            if(isEmpty && request==0){
                System.out.println("underflow");
                continue;
            }
            else if (!isEmpty && request ==0) {
                queue.remove();
                if(queue.size()==0){
                    System.out.println("empty");
                    isEmpty =true;
                }
                else {printQueue(queue);}

            }
            else if (queue.size()>=9 && request!=0) {
                System.out.println("overflow");continue;
            }

            else {
                queue.add(request);
                isEmpty=false;
                printQueue(queue);
            }


        }
    }

    private static void printQueue(Queue<Integer> queue) {
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

