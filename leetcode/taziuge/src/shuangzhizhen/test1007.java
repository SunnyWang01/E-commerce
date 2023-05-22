package shuangzhizhen;

import java.util.HashSet;
import java.util.Scanner;

public class test1007 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int result = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                len++;
            }
            else{
                result = Math.max(result, len);
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                    len--;
                }
                set.add(s.charAt(right));
                len++;
            }
            right++;
        }
        System.out.println(result);
    }
}
