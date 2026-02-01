import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()); // N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Queue<Integer>> want = new HashMap<>();
        List<int[]> order = new ArrayList<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            order.add(arr);
        }            //손님 주문 목록 입력

        for(int i=0; i<N; i++){
            int[] tmp = order.get(i);

            for(int s : tmp){
                if(!want.containsKey(s)){
                    want.put(s, new ArrayDeque<>());
                }
                want.get(s).add(i+1);
            }
        }
        
        HashMap<Integer, Integer> sushi = new HashMap<>();
        int[] ans = new int[N+1];

        st = new StringTokenizer(br.readLine()); // 스시 종류, 개수 입력
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sushi.put(key, sushi.getOrDefault(key, 0) + 1);
        }

        for(int s : sushi.keySet()){
            if(!want.containsKey(s)) continue;
            
            int cnt = sushi.get(s);//스시 별 재고 수

            Queue<Integer> q = want.get(s);
            while(cnt-- > 0 && !q.isEmpty()){//재고가 있고 원하는 사람도 있을 때
                int customer = q.poll();
                ans[customer]++;
            }
        }

        for(int i=1; i<=N; i++) sb.append(ans[i] + " ");

        System.out.print(sb);
        
    }
}
