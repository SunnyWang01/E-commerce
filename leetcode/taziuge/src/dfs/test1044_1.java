package dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class test1044_1 {
    static LinkedList<Integer>[] edges;
    static int[] visited;
    static int total;
    static int[] w;

    static int maxCount = 0;
    static int minSum = Integer.MAX_VALUE;

    public  static void dfs(int totalCount, int totalSum, LinkedList<Integer> list){
        if(totalSum > total) return;
        if(totalCount > maxCount){
            maxCount = totalCount;
            minSum = totalSum;
        }
        if(totalCount == maxCount && totalSum < minSum){
            minSum = totalSum;
        }
        for(int i : list){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            dfs(totalCount+1, totalSum+w[i], edges[i]);
            visited[i] = 0;
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        total = in.nextInt();
        w = new int[n+1];
        for(int i = 1; i<=n; i++){
            w[i] = in.nextInt();
        }
        edges = new LinkedList[n+1];
        visited = new int[n+1];
        for(int i = 0; i<=n; i++){
            edges[i] = new LinkedList<>();
            visited[i] = 0;
        }
        for(int i = 0; i<n-1; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            edges[u].add(v);
            edges[v].add(u);
        }
        if(total < w[1]){
            System.out.println(0+" "+0);
            return;
        }
        visited[1] = 1;
        dfs(1, w[1], edges[1]);
        System.out.println(maxCount+" "+minSum);
    }
}
