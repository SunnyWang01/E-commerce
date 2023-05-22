package shuangzhizhen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class test1088 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            a[i] = in.nextInt();
        }

        int left = 0;
        int right = 0;
        int result = Integer.MIN_VALUE;
        while(right < n){
            map.put(a[right], map.getOrDefault(a[right], 0)+1);
            while (map.size() > k){
                map.put(a[left], map.get(a[left])-1);
                if(map.get(a[left]) == 0) map.remove(a[left]);
                left++;
            }
            result = Math.max(result, right - left +1);
            right++;
        }
        System.out.println(result);
    }
}
