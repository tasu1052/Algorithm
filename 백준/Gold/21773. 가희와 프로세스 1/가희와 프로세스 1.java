import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> q = new PriorityQueue<>((a, b) -> {
                if(a.priority == b.priority) return Integer.compare(a.id, b.id);
                return Integer.compare(b.priority, a.priority);
        });

        for(int i=0; i<n; i++){
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.add(new Process(a,b,c));
        }

        for(int i=0; i<t; i++) {
            Process p = q.poll();

            sb.append(p.id).append('\n');

            p.priority--;
            p.time--;

            if (p.time > 0) q.add(p);
        }

        System.out.println(sb);
    }
}
class Process {
    int id, time, priority;

    public Process(int id, int time, int priority) {
        this.id = id;
        this.time = time;
        this.priority = priority;
    }
}