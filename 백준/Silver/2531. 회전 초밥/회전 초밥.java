import java.io.*;
import java.util.*;

public class Main {
    static String[] cmd = {"D", "S", "L", "R"};
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

        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            int tmp = 0;
            for(int j = i, n = 0; n<k; j++, n++){
                if(j >= N) j = 0;

                hm.put(sushi[j], hm.getOrDefault(sushi[j], 0) + 1);

            }
            if(!hm.containsKey(c)) tmp = hm.size() + 1;
            else tmp = hm.size();

            maxCnt = Math.max(tmp, maxCnt);
        }
        System.out.println(maxCnt);
    }
}