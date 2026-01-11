import java.io.*;
import java.util.*;

public class Main{
    static boolean[] water;
    static boolean[][] visited;
    static int A, B, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1];
        water = new boolean[C+1];

        dfs(0, 0, C);

        for(int i=0; i<water.length; i++){
            if(water[i]) sb.append(i).append(" ");
        }
        
        System.out.print(sb);
    }
    static void dfs(int a, int b, int c) {
        if (visited[a][b]) return;
        visited[a][b] = true;
        
        if(a ==0 && !water[c]){
            water[c] = true;
        }

        int move;

        // A → B
        move = Math.min(a, B - b);
        dfs(a - move, b + move, c);

        // A → C
        move = Math.min(a, C - c);
        dfs(a - move, b, c + move);

        // B → A
        move = Math.min(b, A - a);
        dfs(a + move, b - move, c);

        // B → C
        move = Math.min(b, C - c);
        dfs(a, b - move, c + move);

        // C → A
        move = Math.min(c, A - a);
        dfs(a + move, b, c - move);

        // C → B
        move = Math.min(c, B - b);
        dfs(a, b + move, c - move);
    }
}