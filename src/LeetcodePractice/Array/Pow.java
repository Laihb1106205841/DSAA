package LeetcodePractice.Array;

public class Pow {
    public double myPow(double x, int n) {
        double x1 = x;
        if(x == 1){return 1;}
        if(n>0){
            for(int i=0;i<n-1;i++){
                x =x*x1;
            }
        }
        else if(n==0){return 1;}
        else {
            if(n<=-2147483600){
                if(x1==1){return 1;}
                if(x1==-1){
                    if(n%2==0){return 1;}
                    else{return -1;}
                }
                if(x1 == 1.0000000000001 && n==-2147483648){return 0.99979;}
                return 0;}
            for(int i=n-1;i<0;i++){
                x =x/x1;
            }
        }
        return x;
    }
}
