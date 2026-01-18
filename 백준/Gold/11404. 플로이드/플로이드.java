import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());

        int INF = Integer.MAX_VALUE;

        long[][] dist = new long[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[s][e] = Math.min(dist[s][e], w);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][k] != INF && dist[k][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dist[i][j] == INF){
                    sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
                    continue;
                }
                sb.append(dist[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}