package LeetcodePractice.Array;


import java.util.regex.Pattern;
import java.util.regex.Matcher;





public abstract class Others {
    public boolean isPerfectSquare(int num) {
        if(num == 1){return true;}

        int left =1;
        int right = num-1;

        while (left<right){
            int half = left+(-left+right) /2;
            if(half*half == num){
                return true;
            }else if(half*half < num){
                left = half+1;
            }else if(half*half > num){
                right = half;
            }
        }
        return left*left==num;
    }
    abstract int guess(int num);

    public int guessNumber(int n) {
        int left = 1;
        int right= n;

        while (left<right){
            int half = left+(right-left)>>1;
            if(guessNumber(half)==0){
                right = half;
            }else if(guessNumber(half)==-1){
                left = half+1;
            }else if(guessNumber(half)==1){
                right = half;
            }
        }
        return left;
    }
    public boolean validUtf8(int[] data) {
        for(int i=0;i<data.length;i++){
            if(data[i]<128){continue;}
            if(data[i]<192||data[i]>=248){return false;}
            if(data[i]<224){
                if(i+2>data.length){return false;}
                if(data[i+1]<128||data[i+1]>=192){return false;}
                i++;
            }
            else if(data[i]<240){
                if(i+3>data.length){return false;}
                for(int j=1;j<=2;j++){if(data[i+j]<128||data[i+j]>=192){return false;}}
                i+=2;
            }
            else{
                if(i+4>data.length){return false;}
                for(int j=1;j<=3;j++){if(data[i+j]<128||data[i+j]>=192){return false;}}
                i+=3;
            }
        }
        return true;
    }

}
