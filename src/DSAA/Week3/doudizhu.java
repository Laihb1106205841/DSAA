package DSAA.Week3;

import java.util.Scanner;

public class doudizhu {
    public static void Insert(int[] array){
        for(int j=1;j<array.length; j++){
            int key = array[j];
            //insert

            int i =j-1;
            while(i>=0 && array[i]<key){
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1]=key;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String Whom = scanner.next();

            if(Whom.contains("F")){
                int[] arr = new int[18];//is 17!
                for(int i=0;i<17;i++) {//change
                    String next = scanner.next();
                    if (next.contains("2")) {
                        arr[15] += 1;
                    } else if (next.contains("RJ")) {
                        arr[17] +=1;
                    } else if (next.contains("WJ")) {
                        arr[16] += 1;
                    } else if (next.contains("A")) {
                        arr[14] += 1;
                    } else if (next.contains("K")) {
                        arr[13] += 1;
                    } else if (next.contains("Q")) {
                        arr[12] += 1;
                    } else if (next.contains("J")) {
                        arr[11] += 1;
                    } else {
                        arr[Integer.parseInt(next)]+=1;
                    }
                }
                int setout = 0;
                if(arr[17] !=0){System.out.printf("RJ ");arr[17]=0;setout+=1;}
                if(arr[16] !=0){System.out.printf("WJ ");arr[16]=0;setout+=1;}

                for(int i=0;i<arr.length;i++){

                    int max = 0;
                    for(int j=0;j<arr.length;j++) {
                        if (arr[j] > max) {
                            max = arr[j];
                        }
                    }

                    if(max == 0){break;}
                    else {
                        for (int j = arr.length-1; j > 0; j--) {
                            if(arr[j] == max){
                                String b = Integer.toString(j);
                                if(j == 17){b = "RJ";}
                                if(j == 16){b = "WJ";}
                                if(j == 15){b = "2";}
                                if(j == 14){b = "A";}
                                if(j == 13){b = "K";}
                                if(j == 12){b = "Q";}
                                if(j == 11){b = "J";}
                                for (int k = 0;k<max;k++){
                                    System.out.print(b);setout+=1;
                                    if(setout<17){System.out.print(" ");}
                                }
                                arr[j] = 0;
                            }
                        }
                    }
                }

                }
            if(Whom.contains("D")){
                int[] arr = new int[18];//is 17!
                for(int i=0;i<20;i++) {//change
                    String next = scanner.next();
                    if (next.contains("2")) {
                        arr[15] += 1;
                    } else if (next.contains("RJ")) {
                        arr[17] +=1;
                    } else if (next.contains("WJ")) {
                        arr[16] += 1;
                    } else if (next.contains("A")) {
                        arr[14] += 1;
                    } else if (next.contains("K")) {
                        arr[13] += 1;
                    } else if (next.contains("Q")) {
                        arr[12] += 1;
                    } else if (next.contains("J")) {
                        arr[11] += 1;
                    } else {
                        arr[Integer.parseInt(next)]+=1;
                    }
                }
                int setout = 0;
                if(arr[17] !=0){System.out.print("RJ ");arr[17]=0;setout+=1;}
                if(arr[16] !=0){System.out.print("WJ ");arr[16]=0;setout+=1;}

                for(int i=0;i<arr.length;i++){
                    int max = 0;
                    for(int j=0;j<arr.length;j++) {
                        if (arr[j] > max) {
                            max = arr[j];
                        }
                    }

                    if(max == 0){break;}
                    else {
                        for (int j = arr.length-1; j > 0; j--) {
                            if(arr[j] == max){
                                String b = Integer.toString(j);
                                if(j == 17){b = "RJ";}
                                if(j == 16){b = "WJ";}
                                if(j == 15){b = "2";}
                                if(j == 14){b = "A";}
                                if(j == 13){b = "K";}
                                if(j == 12){b = "Q";}
                                if(j == 11){b = "J";}
                                for (int k = 0;k<max;k++){
                                    System.out.print(b);setout+=1;
                                    if(setout<20){System.out.print(" ");}
                                }
                                arr[j] = 0;
                            }
                        }
                    }
                }

            }

            //has next
        }

    }
}

