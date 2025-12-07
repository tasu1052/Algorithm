import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            HashMap<String, Integer> hm = new HashMap<>();
            int clothesNum = Integer.parseInt(br.readLine());

            for(int i=0; i<clothesNum; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                hm.put(type, hm.getOrDefault(type, 0) + 1);
            }
            int result = 1;
            for(int cnt : hm.values()){
                result *= cnt + 1;
            }
            sb.append(result - 1).append('\n');
        }
        System.out.print(sb);
    }
}
