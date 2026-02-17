import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int end;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine()); //전체 사람 수 n

        A = new ArrayList[n+1];
        for(int i=0; i<=n; i++) A[i] = new ArrayList<>();
        visited = new boolean[n+1];
        
        st = new StringTokenizer(br.readLine()); //촌수 계산해야하는 사람들
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
    	int m = Integer.parseInt(br.readLine()); //관계 개수

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        dfs(start, 0);
        
    	if(ans != 0) System.out.print(ans);
        else System.out.print(-1);
    }

    static void dfs(int idx, int sum){
        visited[idx] = true;
        
        if(idx == end){
            ans = sum;
            return; //sum;
        }

        for(int next : A[idx]){
            if(!visited[next]){
                dfs(next, sum + 1);
            }
        }

        return;
    }
}