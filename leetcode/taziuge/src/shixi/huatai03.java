package shixi;

import java.util.Scanner;

public class huatai03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] arr = new long[n+1];
        long[][] dp = new long[n+1][k];
        for(int i = 0; i<=n;i++){
            for(int j = 0; j<k; j++){
                dp[i][j] = Long.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i =1; i<=n; i++){
            arr[i] = in.nextInt();
            for (int j = 0; j<k; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][(k+j-(int)(arr[i]%k))%k]+arr[i]);
            }
        }
        if(dp[n][0]<=0){
            System.out.println(-1);
        }else{
            System.out.println(dp[n][0]);
        }
    }
}
