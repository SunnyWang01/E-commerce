package dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class test1065 {
    static LinkedList<int[]>[] edges;
    static int result = Integer.MIN_VALUE;

    public static int[] dfs(int root, int parent){
        int[] res = new int[]{0 ,0};
        for(int[] e : edges[root]){
            if(e[0] == parent) continue;
            int[] re = dfs(e[0], root);
            if(e[1] == 1) res[1] = Math.max(res[1], re[1]+1);
            else res[0] = Math.max(res[0], re[1]+1);
            }
        result = Math.max(res[1]+res[0], result);
        return res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        edges = new LinkedList[n+1];
        for(int i = 0; i<=n; i++) edges[i] = new LinkedList<>();
        for(int i = 0; i<n-1; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            String s = in.next();
            if(s == "R") {
                edges[v].add(new int[]{u, 1});
                edges[u].add(new int[]{v, 1});
            }
            else {
                edges[u].add(new int[]{v, 0});
                edges[v].add(new int[]{u, 0});
            }
        }
        dfs(1, 0);
        System.out.println(result);
    }
}
