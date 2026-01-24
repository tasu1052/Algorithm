import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> tm = new TreeMap<>(); // 인덱스, 개수

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                } 
                else {
                    if (tm.isEmpty()) continue;

                    int key = (num == 1) ? tm.lastKey() : tm.firstKey();
                    int cnt = tm.get(key) - 1;

                    if (cnt == 0) tm.remove(key);
                    else tm.put(key, cnt);
                }
            }
            if(tm.isEmpty()) sb.append("EMPTY\n");
            else sb.append(tm.lastKey() + " " + tm.firstKey() + '\n');
        }

        System.out.print(sb);
    }
}
