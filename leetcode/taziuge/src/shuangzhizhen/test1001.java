package shuangzhizhen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];

        int left = 0;
        int right = 0;
        int result = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        while(right < n){
            count.put(a[right], count.getOrDefault(a[right], 0)+1);
            while(count.get(a[right]) >= x){
                result += n - right;
                count.put(a[left], count.get(a[left])-1);
                left++;
            }
            right++;
        }
        System.out.println(result);
    }
}
