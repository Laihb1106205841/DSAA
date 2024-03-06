package ADAS.Week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class QA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        HashMap<String,Integer> BoyMap = new HashMap<>();
        String[] boy  = new String[N];
        for(int i =0;i<N;i++){
            boy[i] = scan.next();
            BoyMap.put(boy[i],i);
        }

        HashMap<String,Integer> GirlMap = new HashMap<>();
        String[] girl = new String[N];
        for(int i=0;i<N;i++){
            girl[i] = scan.next();
            GirlMap.put(girl[i],i);
        }

        String[][] boy_preference = new String[N][N];
        String[][] girl_preference = new String[N][N];

        for(int i =0;i < N;i++){
            for(int j=0;j<N;j++){
                boy_preference[i][j] = scan.next();
            }
        }

        for(int i =0;i < N;i++){
            for(int j=0;j<N;j++){
                girl_preference[i][j] = scan.next();
            }
        }

        ArrayList<String> freeBoy = new ArrayList<>();
        Collections.addAll(freeBoy, boy);

        int[][] Girl_Inverse = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j< N;j++){
                String m = girl_preference[i][j];
                int index = BoyMap.get(m);
                Girl_Inverse[i][index] = j;
            }
        }

        int[] husband = new int[N];
        int[] wife = new int[N];
        int[] count = new int[N];

        for(int i=0;i<N;i++){
            husband[i] = -1;
            wife[i] = -1;
        }

        while (!freeBoy.isEmpty()){
            String man = freeBoy.remove(0);
            int Man_position = BoyMap.get(man);

            String woman = boy_preference[Man_position][count[Man_position]];
            int Woman_position = GirlMap.get(woman);
            if(wife[Woman_position] == -1){ //is free
                wife[Woman_position] = Man_position;
                husband[Man_position] = Woman_position;
            }
            else {
                int fiance = wife[Woman_position];
                if(Girl_Inverse[Woman_position][Man_position] < Girl_Inverse[Woman_position][fiance]){
                    freeBoy.add(boy[fiance]);
                    husband[fiance] = -1;
                    count[fiance]+=1;

                    wife[Woman_position] = Man_position;
                    husband[Man_position] = Woman_position;

                }else {
                    count[Man_position]+=1;
                    freeBoy.add(man);
                }
            }
        }

        for(int i =0;i<husband.length;i++){
            System.out.println(boy[i]+" "+girl[husband[i]]);
        }

    }

}
