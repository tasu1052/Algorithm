import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            int count = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<=N-K; j++){
                    boolean ok = true;
                    for(int k=0; k<K; k++){
                        if(arr[i][j+k]!=1){
                            ok = false;
                            break;
                        }
                    }
                    if(!ok) continue;

                    boolean leftIsZeroOrEdge = (j-1<0) || (arr[i][j-1]==0);
                    boolean rightIsZeroOrEdge = (j+K>=N) || (arr[i][j+K]==0);

                    if(leftIsZeroOrEdge && rightIsZeroOrEdge) count++;
                }
            }

            for(int j=0; j<N; j++){
                for(int i=0; i<=N-K; i++){
                    boolean ok = true;
                    for(int k=0; k<K; k++){
                        if(arr[i+k][j]!=1){
                            ok = false;
                            break;
                        }
                    }
                    if(!ok) continue;

                    boolean topIsZeroOrEdge = (i-1<0) || (arr[i-1][j]==0);
                    boolean bottomIsZeroOrEdge = (i+K>=N) || (arr[i+K][j]==0);

                    if(topIsZeroOrEdge && bottomIsZeroOrEdge) count++;
                }
            }
            sb.append("#").append(t).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
    }
}