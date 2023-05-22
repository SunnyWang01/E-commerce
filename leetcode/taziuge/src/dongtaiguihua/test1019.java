package dongtaiguihua;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test1019 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] center = new int[n];
        int[] len = new int[n];
        int[][] line = new int[n][3];

        for(int i = 0; i<n; i++){
            center[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            len[i] = in.nextInt();
            line[i][0] = center[i] - len[i];
            line[i][1] = center[i] + len[i];
        }

        for (int i = 0; i < n; i++) {
            line[i][2] = in.nextInt();
        }
        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[n];
        dp[0] = line[0][2];
        int result = dp[0];
        for(int i = 1; i<n; i++){
            dp[i] = line[i][2];
            for(int j = 0; j<i; j++){
                if(line[i][0] >= line[j][1]) dp[i] = Math.max(dp[i], dp[j]+line[i][2]);
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
