import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] size = new int[6];
        
        for(int i=0; i<size.length; i++){
            size[i]=Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int count=0;
        
        for(int i=0; i<size.length; i++){
            count+=(size[i] + T - 1)/T;
        }
        System.out.println(count);
        System.out.print(N/P+ " " + N%P);
    }
}
