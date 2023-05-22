package dongtaiguihua;

import java.util.Scanner;

public class test1004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        if(sum % 2 != 0){
            System.out.println(0);
            return;
        }
//        int[][] dp = new int[n+1][sum/2+1];
//
//        for(int i = 0; i<=n; i++){
//            dp[i][0] = 1;
//        }
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= sum/2; j++ ){
//                dp[i][j] = dp[i-1][j];
//                if(j-a[i-1] >= 0) dp[i][j] += dp[i-1][j-a[i-1]];
//            }
//        }
        //滚动数组优化
        int[] dp = new int[sum/2+1];
        for(int i = 0; i<n; i++){
            for(int j = sum/2; j>=0; j--){
                if(j == a[i]) dp[j]++;
                if(j > a[i] && j - a[i] >= 0) dp[j] += dp[j-a[i]];
            }
        }
        System.out.println(dp[sum/2]);
    }
}
