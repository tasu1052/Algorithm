import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int min1=x;
        
        if(min1>y)
            min1=y;
        else
            min1=x;
        
        int min2=w-x;
        
        if(min2>h-y)
            min2=h-y;
        else
            min2=w-x;
        
        if(min1>min2)
            System.out.print(min2);
        else
            System.out.print(min1);
        
    }
}