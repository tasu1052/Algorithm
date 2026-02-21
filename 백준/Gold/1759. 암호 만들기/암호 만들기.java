import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char[] alpha;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        visited = new boolean[C];


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) alpha[i] = st.nextToken().charAt(0);
        
        Arrays.sort(alpha);

        dfs(0, 0, 0, 0);

        System.out.print(sb);
    }
    static void dfs(int idx, int cnt, int vow, int con){
        if(cnt == L && vow >= 1 && con >= 2){//암호가 완성되면 출력하고 한줄 넘기기
            for(int i=0; i<C; i++){
                if(visited[i]) sb.append(alpha[i]);
            }
            sb.append('\n');
            return;
        }
        
        if(idx == C) return; //배열 끝까지 탐색한 경우 종료
        
        for(int i=idx; i<C; i++){
            if(visited[i]) continue;

            visited[i] = true;
            if("aeiou".indexOf(alpha[i]) >= 0) dfs(i + 1, cnt + 1, vow + 1, con);
            else dfs(i + 1, cnt + 1, vow, con + 1);
            visited[i] = false;
        }
    }
}