import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        
        int N = Integer.parseInt(br.readLine());
        //int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            q.offer(i+1);
        }
        
        while(q.size()>1){
            q.pop();
            q.offer(q.pop());
            
            if(q.size()==1)
                break;
        }
        System.out.print(q.peek());
    }
}