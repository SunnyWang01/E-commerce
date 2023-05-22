package shixi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class huawei01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int n = s1.length;
        LinkedList<Long> input = new LinkedList<>();

        for(int i = 0; i < n; i++){
            input.add(Long.parseLong(s1[i]));
        }

        LinkedList<Long> presum = new LinkedList<>();
        presum.add(0L);
        LinkedList<Long> stack = new LinkedList<>();
        while(!input.isEmpty()){
            boolean flag = false;
            long temp = input.pop();
            if(stack.isEmpty()){
                stack.push(temp);
                presum.push(temp);
                continue;
            }
            if(temp == stack.peek()){
                stack.pop();
                presum.pop();
                input.add(0, 2*temp);
                continue;
            }
            for(int i = 1; i <= presum.size()-1 && !flag; i++){
                long peek = presum.peek();
                long g = presum.get(i);

                if((peek - g ) == temp){
                    int num =  i;

                    for(int t = 0; t < num; t++){
                        stack.pop();
                        presum.pop();
                    }
                    input.add(0, 2*temp);
                    flag = true;
                }
            }
            if(!flag){
                stack.push(temp);
                presum.push(presum.peek() + temp);
            }

        }
        for(int i = 0; i<stack.size()-1; i++){
            System.out.print(stack.get(i)+" ");
        }
        System.out.println(stack.get(stack.size()-1));

    }
}
