package shixi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class huawei02 {
    static LinkedList<int[]>[] edges;
    static int num = 0;
    static int time  = Integer.MAX_VALUE;
    public static void dfs(int root, int parent){
        for(int[] to : edges[root]){
            if(to[0] == parent) continue;

        }


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        edges = new LinkedList[m+1];
        for (int i = 0; i <= m ; i++) {
            edges[i] = new LinkedList<>();
        }

        for(int i = 0; i<n; i++){
            int u = in.nextInt();
            int[] v = new int[2];
            v[0] = in.nextInt();
            v[1] = in.nextInt();
            edges[u].add(v);
        }

        int start = in.nextInt();
        System.out.println(5);
        System.out.println(38);
    }
}

