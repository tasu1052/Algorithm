import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) A[i] = new ArrayList<Integer>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=0; i<N; i++){
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            
            if(check){
                System.out.print(1);
                break;
            }
        }

        if(!check) System.out.print(0);
        
    }
    static void dfs(int v, int length){
        if(length == 5){
            check = true;
            return;
        }
        for(int i : A[v]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, length + 1);
                visited[i] = false;
            }
        }
    }
}