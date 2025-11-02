import java.io.*;
import java.util.*;
     
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
             
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            String tc = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> hm = new HashMap<>();
            hm.put("ZRO", 0);
            hm.put("ONE", 1);
            hm.put("TWO", 2);
            hm.put("THR", 3);
            hm.put("FOR", 4);
            hm.put("FIV", 5);
            hm.put("SIX", 6);
            hm.put("SVN", 7);
            hm.put("EGT", 8);
            hm.put("NIN", 9);

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = hm.get(st.nextToken());
            }

            Arrays.sort(arr);

            HashMap<Integer, String> reverseMap = new HashMap<>();
            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                reverseMap.put(entry.getValue(), entry.getKey());
            }
            
            sb.append(tc).append('\n');
            for (int num : arr) {
                sb.append(reverseMap.get(num) + " ");
            }
        }
        System.out.print(sb);
    }
}