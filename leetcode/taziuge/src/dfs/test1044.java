package dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class test1044 {
    static LinkedList<Integer>[] edges;
    static int[] visited;
    static int total;
    static int[] w;

    public static boolean compare(int[] a, int[] b){
        if(a[0] > b[0]) return true;
        if(a[0] == b[0] && a[1] <= b[1] ) return true;
        return false;
    }
    public  static int[] dfs(int root, int parent){
        int[] t = new int[]{0, Integer.MAX_VALUE};
        int t2 = 0;
        for(int i: edges[root]){
            if(i == parent) continue;
            if(visited[i] == 0 ){
                int[] temp = dfs(i, root);
                if(w[root]+ temp[1] <= total){
                    if(compare(dfs(i, root), t)){
                        t = temp;
                        t2 = i;
                    }
                }
            }
        }
        visited[t2] = 1;
        if(t[1] == Integer.MAX_VALUE) {
            return new int[]{1, w[root]};
        }
        return new int[]{t[0]+1, t[1]+w[root]};
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
        int[] result = dfs(1, 0);
        System.out.println(result[0]+" "+result[1]);
    }
}
