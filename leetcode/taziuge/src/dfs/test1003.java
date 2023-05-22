package dfs;

import java.util.Scanner;

public class test1003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int total = 0;
        int sum = 0;
        int minW = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            total ^= a[i];
            minW = Math.min(minW, a[i]);
            sum += a[i];
        }
        if(total == 0) System.out.println(sum - minW);
        else System.out.println("NO");
    }
}
