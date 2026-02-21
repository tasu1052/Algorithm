import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Pos> houses;
    static ArrayList<Pos> chickens;
    static int ans;
    static boolean[] pick;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int v = Integer.parseInt(st.nextToken());
                if(v == 1) houses.add(new Pos(i, j));
                else if(v == 2) chickens.add(new Pos(i, j));
            }
        }

        pick = new boolean[chickens.size()];

        dfs(0, 0);
        
        System.out.print(ans);
    }

    static void dfs(int idx, int cnt){
        if(cnt == M){
            ans = Math.min(ans, calCityDist());
            return;
        }

        if(idx == chickens.size()) return;

        if(cnt + (chickens.size() - idx) < M) return;

        pick[idx] = true;
        dfs(idx + 1, cnt + 1);

        pick[idx] = false;
        dfs(idx + 1, cnt);
    }

    static int calCityDist(){
        int sum = 0;

        for(Pos h : houses){
            int bestDist = Integer.MAX_VALUE;

            for(int i=0; i<chickens.size(); i++){
                if(!pick[i]) continue;
                Pos c = chickens.get(i);
                int d = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                if(d < bestDist) bestDist = d;
            }

            sum += bestDist;

            if(sum >= ans) return sum;
        }
        return sum;
    }
}
class Pos{
    int x, y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}