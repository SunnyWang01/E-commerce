package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class test1036 {
    static LinkedList<Integer>[] edges;
    static char[] flag;
    public static int dfs(int root, int parent){
        int sum = 0;
        for(int i: edges[root]){
            if(i == parent) continue;
            sum += dfs(i, root);
        }
        if(sum %2 == 0){
            flag[root] = 'B';
            return sum+1;
        }else {
            return sum;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edges = new LinkedList[n+1];
        flag = new char[n+1];
        Arrays.fill(flag, 'R');
        for(int i = 0; i<=n; i++) edges[i] = new LinkedList<>();
        for(int i = 0; i<n-1; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        dfs(1, 0);
        for(int i = 1; i<=n;i++){
            System.out.print(flag[i]);
        }
    }
}
