import java.io.*;
import java.util.*;

public class Main{
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        int[][] city = new int[N][N];
        int[] path = new int[M];
        for(int i=0; i<N+1; i++) parent[i] = i;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) union(i+1, j+1);
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) path[i] = Integer.parseInt(st.nextToken());
        
        int root = find(path[0]);
        for(int i=1; i<M; i++){
            if(find(path[i]) != root){
                System.out.print("NO");
                return;
            }
        }

        System.out.print("YES");
        
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}