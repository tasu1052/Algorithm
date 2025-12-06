import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        arr[N] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K){
                sb.append(arr[now]);
                break;
            }

            int[] nextList = {now - 1, now + 1, now * 2};

            for(int next : nextList){
                if(next < 0 || next > 100000) continue;
                if(visited[next]) continue;

                visited[next] = true;
                arr[next] = arr[now] + 1;
                q.add(next);
            }
        }
        
        System.out.print(sb);
    }
}