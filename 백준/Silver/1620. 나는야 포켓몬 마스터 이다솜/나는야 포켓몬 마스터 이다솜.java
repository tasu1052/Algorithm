import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> hmkv = new HashMap<>();
        HashMap<String, Integer> hmvk = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            hmkv.put(i, name);
            hmvk.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String check = br.readLine();
            if (isInteger(check))
                sb.append(hmkv.get(Integer.parseInt(check))).append('\n');
            else 
                sb.append(hmvk.get(check)).append('\n');
        }
        System.out.print(sb);
    }

    public static boolean isInteger(String S) {
        return S.matches("\\d+");
    }
}