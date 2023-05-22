package dfs;

import java.util.Scanner;

public class test1017 {

    static long len = Long.MIN_VALUE;
    static long result = -1;
    //最大的数为987654321，合起来有45，所以n>45的话是找不到结果的为-1.
    public static void dfs(int target, int start, long sum, long count, StringBuilder builder){
        if(sum > target) return;
        if(sum == target){
            if(count > len){
                result = Long.parseLong(builder.toString());
                len  = count;
            }
        }

        for(int i = start; i >= 1; i--){
            sum += i;
            count += 1;
            builder.append(i);
            dfs(target, i-1, sum, count, builder);
            builder.deleteCharAt(builder.length()-1);
            sum -= i;
            count -= 1;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        dfs(target, 9, 0, 0, new StringBuilder());
        System.out.println(result);
    }
}
