package shuangzhizhen;

import java.util.*;

public class test1071 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] tag = new int[200005];
        while(T > 0){
            int n = in.nextInt();
            int[] a = new int[n];
            int left = 0;
            int right = n-1;
            int result = 1;
            for(int i = 0; i<n; i++){
                a[i] =in.nextInt();
                tag[a[i]] = 1;
            }
            while(left < right){
                boolean flag = true;
                if(a[left] > a[right]){
                    tag[a[left]] = 0;
                    for (int j = 1; j <= right- left && flag; j++) {
                        if(tag[j] == 0){
                            flag = false;
                        }
                    }
                    if(flag) result++;
                    left++;
                }else{
                    tag[a[right]] = 0;
                    for (int j = 1; j <= right - left && flag; j++) {
                        if(tag[j] == 0){
                            flag = false;
                        }
                    }
                    if(flag) result++;
                    right--;
                }
            }
            System.out.println(result);
            Arrays.fill(tag, 0);
            T--;
        }
    }
}
