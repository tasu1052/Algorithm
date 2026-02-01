import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] sushiCnt = new int[d+1];
        int kind = 0;
        for(int i=0; i<k; i++){
            if(sushiCnt[sushi[i]] == 0) kind++;
            sushiCnt[sushi[i]]++;
        }

        int max = kind + (sushiCnt[c] == 0 ? 1 : 0);

        for(int i=1; i<N; i++){
            int remove = sushi[i -1];
            sushiCnt[remove]--;
            if(sushiCnt[remove] == 0) kind--;

            int add = sushi[(i + k -1) % N];
            if(sushiCnt[add] == 0) kind++;
            sushiCnt[add]++;

            int now = kind + (sushiCnt[c] == 0 ? 1 : 0);
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}