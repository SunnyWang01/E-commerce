package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class test1031 {
    static int result = Integer.MAX_VALUE;

    public static void dfs(int[] a, int sum1, int sum2, int sum3, int start){
        if(start >= a.length){
            if(sum1 == sum2 || sum1 == sum3|| sum2 == sum3){
                return;
            }
            int maxV = sum1> sum2 ? (sum1>sum3?sum1 : sum3):(sum2>sum3? sum2:sum3);
            int minV = sum1<sum2 ? (sum1<sum3? sum1 : sum3) : (sum2<sum3? sum2: sum3);
            result = Math.min(result, maxV - minV);
            return;
        }
        dfs(a, sum1+a[start], sum2, sum3, start+1);
        dfs(a, sum1, sum2+a[start], sum3, start+1);
        dfs(a, sum1, sum2, sum3+a[start], start+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = in.nextInt();
        }
        dfs(a, 0, 0,0, 0);
        if(result != Integer.MAX_VALUE) System.out.println(result);
        else System.out.println(0);
    }
}
