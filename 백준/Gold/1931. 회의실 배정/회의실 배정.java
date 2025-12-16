import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> q = new PriorityQueue<>((a, b) -> {
            if(a.end == b.end) return a.start - b.start;
            return a.end - b.end;
        });

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            q.add(new Meeting(s, e));
        }

        int cnt = 1;
        int startTime = q.poll().end;
        
        while(!q.isEmpty()){
            Meeting cur = q.poll();
            if(startTime <= cur.start){
                startTime = cur.end;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
class Meeting{
    int start;
    int end;

    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}