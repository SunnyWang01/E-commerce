package shuangzhizhen;

import java.util.HashSet;

public class debug {
    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        set.add('c');
        set.add('d');
        set.add('e');
        set.remove('c');
        for (Character c: set) {
            System.out.println(c);

        }
    }
}
