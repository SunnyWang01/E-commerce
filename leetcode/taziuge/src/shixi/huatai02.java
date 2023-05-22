package shixi;

import java.util.HashMap;
import java.util.Scanner;

public class huatai02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        char[] a = s.toCharArray();
        int total0  = 0;
        int total1 = 0;
        int temp0 = 0;
        int temp1 = 0;
        for(int i = 0; i<n; i++){
            if(a[i] == '1') total1++;
            else total0++;
            if(i < n/2) {
                temp0 = total0;
                temp1 = total1;
            }
        }
        if(total0%2!=0 || total1%2!=0){
            System.out.println(0);
            return;
        }
        int start = 0;
        int result = 0;
        while(start<n){
            if(temp1 == total1/2 && temp0 == total0/2) result++;
            if(a[start] == '1') temp1--;
            else temp0--;
            start++;
            if(a[(start+n/2-1)%n] == '1') temp1++;
            else temp0++;
        }
        System.out.println(result);
    }
}
