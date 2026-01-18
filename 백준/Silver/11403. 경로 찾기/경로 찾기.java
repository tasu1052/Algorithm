import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

    	int N = Integer.parseInt(br.readLine());

        int INF = Integer.MAX_VALUE;

        long[][] dist = new long[N+1][N+1];

        for(int i=1; i<=N; i++){ 
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                sb.append(dist[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}