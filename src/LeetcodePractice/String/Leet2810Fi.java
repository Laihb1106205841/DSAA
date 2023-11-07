package LeetcodePractice.String;

public class Leet2810Fi {
    public String finalString(String s) {
        StringBuilder sb =new StringBuilder();
        for (int i =0; i<s.length(); i++){
            if(s.charAt(i)!='i'){sb.append(s.charAt(i));}
            if(s.charAt(i)=='i'){sb.reverse();}
        }
        return sb.toString();
    }

    static void reverse(char[] arr, int i, int j){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        int i=0; int n=s.length();
        char[] arr=s.toCharArray();
        while(i<n){
            int j=Math.min(i+k-1,n-1);
            reverse(arr,i,j);
            i=i+2*k;
        }
        String str=new String(arr);

        return str;
    }
}
