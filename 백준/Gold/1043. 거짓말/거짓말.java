import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] known = new int[num];
        for(int i=0; i<num; i++) known[i] = Integer.parseInt(st.nextToken());

        List<int[]> parties = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            int[] party = new int[partyNum];
            for(int j=0; j<partyNum; j++){
                party[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(party);

            for(int j=1; j<partyNum; j++){
                union(party[j-1], party[j]);
            }
        }

        int cnt = 0;
        for(int[] party : parties){
            boolean canLie = true;
            for(int p : party){
                for(int k : known){
                    if(find(p) == find(k)){
                        canLie = false;
                        break;
                    }
                }
                if(!canLie) break;
            }
            if(canLie) cnt++;
        }

        System.out.println(cnt);
    }
}