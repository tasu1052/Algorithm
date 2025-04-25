import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> voca = new TreeMap<>();
        for(int i=0; i<N; i++){
            String S = br.readLine();
            if(S.length() >= M){
                voca.put(S, voca.getOrDefault(S,0) + 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(voca.keySet());
        list.sort((a,b) -> {
            int A = voca.get(a);
            int B = voca.get(b);
            if(A != B) return B - A;
            if(a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (String word : list){
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}