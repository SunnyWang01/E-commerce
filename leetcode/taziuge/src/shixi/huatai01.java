package shixi;

import java.util.Scanner;

public class huatai01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder result = new StringBuilder(s).reverse();
        System.out.println(result);
    }
}
