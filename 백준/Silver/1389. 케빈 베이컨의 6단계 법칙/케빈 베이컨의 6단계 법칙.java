import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long INF = 1_000_000_000;
        long[][] dist = new long[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=1; i<=M; i++){ 
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            dist[s][e] = 1;
            dist[e][s] = 1;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long[] ans = new long[N+1];
        long min = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                ans[i] += dist[i][j];
            }
            if(ans[i] < min){
                min = ans[i];
                minIdx = i;
            }
        }

        System.out.print(minIdx);
    }
}