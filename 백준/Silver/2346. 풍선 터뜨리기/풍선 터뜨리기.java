import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<int[]> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=1; i<=N; i++)
            q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        
        /* 2345 3452 4523 5234
            523 352 235 523
            23 32
            이런 식으로 진행되고 양수일 땐 index -1 만큼 뒤로 보내고
            음수일 땐 index만큼 앞으로 보내면
            맨 앞에 원하는 숫자가 위치하게 된다
            */
        while(!q.isEmpty()){
            int[] balloon = q.pollFirst();
            int index = balloon[1];
            
            sb.append(balloon[0]).append(" ");
            
            if(q.isEmpty()) break;
            
            if(index>0){
                for(int i=0; i<index-1; i++){
                    q.offerLast(q.pollFirst());
                }
            }
            else{
                for(int i=0; i<Math.abs(index); i++){
                    q.offerFirst(q.pollLast());
                }
            }
        }
        
        System.out.print(sb);
    }
}