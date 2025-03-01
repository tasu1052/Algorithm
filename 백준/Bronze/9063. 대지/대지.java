import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] x = new int[N];
        int[] y = new int[N];
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        if(N==1){
            System.out.print(0);
            return;
        }
        
        int xmax=x[0];
        int xmin=x[0];
        
        for(int i=1; i<N; i++){
            if(xmax<x[i])
                xmax=x[i];
            if(xmin>x[i])
                xmin=x[i];
        }
        
        int ymax=y[0];
        int ymin=y[0];
        
        for(int i=1; i<N; i++){
            if(ymax<y[i])
                ymax=y[i];
            if(ymin>y[i])
                ymin=y[i];
        }
        
        System.out.print((xmax-xmin)*(ymax-ymin));
    }
}