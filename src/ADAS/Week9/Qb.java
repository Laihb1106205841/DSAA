package ADAS.Week9;

//import java.util.*;

import java.util.Arrays;
import java.util.Scanner;

public class Qb {

    static String str;
    static int n;
    static int[][] f = new int[104][104];

    static int c;

    // Check if the substring in the range [l, r] with length len is a repeating string
    static boolean check(int l, int r, int len){
        for(int i = l; i <= r; i++){
            if(str.charAt(i) != str.charAt((i - l) % len + l)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        n = str.length();

        str = " " + str;


        for(int[] row : f){
            Arrays.fill(row, 10000);
        }

        for(int i = 1; i <= n; i++){
            f[i][i] = 1;
        }

        // j - i == l - 1
        for(int l = 2; l <= n; l++){
            for(int i = 1, j = i + l - 1; j <= n; i++, j++){

                //接起来
                for(int k = i; k < j; k++){
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j]);
                }

                // 折起来
                for(int k = i; k < j; k++){
                    int len = k - i + 1;
                    if(l % len != 0){
                        continue;
                    }
                    if(check(i, j, len)){

                        ////////////////////////////////////////
                        int cnt = l / len;

                        // rem表示B数量
                        int rem = 0;
                        int dvd = cnt;

                        int R =0;
                        int B =0;

                        int Source;

                        String binary = Integer.toBinaryString(cnt);

                        for(int s =0;s<binary.length()-1;s++){
                            if(binary.charAt(s) == '1'){
                                int nm = binary.length()-s-1;
                                R += nm;
                                B+=1;
                            }
                        }

                        if(binary.charAt(binary.length()-1) == '1'){
                            Source = B+1;
                        }else {
                            Source = B;
                        }


                        // 有多少个B，就一定会有B+1个xyz

                        if(i == 1 && B > 0){B-=1;}
//
//                        System.out.println("i:"+i);
//                        System.out.println("j:"+j);
//                        System.out.println("k:"+k);
//                        System.out.println("Source:"+Source);
//                        System.out.println("R: "+R);
//                        System.out.println("B: "+B);


                        int ne = f[i][k] + R+B +(Source-1)*len;
//
//                        System.out.println("f[i][k]:"+f[i][k]);
//                        System.out.println("ne:"+ne);
//                        System.out.println();
                        ////////////////////////////////////////////
                        f[i][j] = Math.min(f[i][j], ne);

                    }
                }
            }
        }

        System.out.println(f[1][n]);
        sc.close();
    }
}

//                        while (dvd > 1){
//                            rem = dvd % 2;//是1：来个B
//                            dvd = dvd / 2;
//
//                            B += rem;
//                            R += Source;//算十位开始的数
//
//                            Source +=1;
//
//                        }
