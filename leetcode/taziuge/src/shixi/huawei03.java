package shixi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class huawei03 {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int n = Integer.valueOf(bufferedReader.readLine());
//        in.nextLine();
        String k = bufferedReader.readLine();
        String res = "-1";
        for(int i =  12; i>0; i--){
            long max = -1;
            for(int j = 0; j<str.length() - i; j++){
                String temp = str.substring(j, j+i);
                long ans = valid(temp, n, k);
                if(ans > max){
                    res = temp;
                    max = ans;
                }
            }
            if(max !=-1){
                System.out.println(res);
                return;
            }

        }
        System.out.println(res);
    }
    public static  long valid(String str, int n, String k){
        long num = Long.parseLong(str);
        long res = 0;
        switch (k){
            case "+":
                res = num + n;
                break;
            case "-" :
                res = num - n;
                break;
            case "*":
                res = num * n;
                break;
        }
        long target = res %10;
        long temp = res;
        if(res == 0){
            return res;

        }
        while(res != 0){
            if(res%10 != target){
                return -1;
            }
            res /= 10;
        }
        return temp;
    }

}
