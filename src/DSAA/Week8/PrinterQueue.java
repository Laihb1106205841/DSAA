package DSAA.Week8;

import java.util.Scanner;

public class PrinterQueue {
    public int[] queue;
    int pointer;

    public PrinterQueue(){
        queue = new int[9];
        pointer = 0;
    }
    public void InsertQ(int val){
        //9 num before
        if(pointer == 8+1){
            System.out.println("overflow");
            return;
        }
        queue[pointer] = val;

        pointer++;

        printQueue();
    }
    public void PopQ(){
        if(pointer == 0){
            System.out.println("underflow");
            return;
        }
        int[] qu = new int[9];
        System.arraycopy(queue, 1, qu, 0, 8);
        queue =qu;

        pointer--;

        if(pointer==0){
            System.out.println("empty");
        }
        else printQueue();
    }

    public void printQueue(){
        for (int j : queue) {
            if (j != 0) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        PrinterQueue queue = new PrinterQueue();

        for (int i = 0; i < q; i++) {
            int request = scanner.nextInt();

            if (request ==0) {
                queue.PopQ();
            }
            else{
                queue.InsertQ(request);
            }

        }
    }

}

