import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int mincount=0;
        int count=0;;
        
        for(int i=0; i<=1667; i++){
            for(int j=0; j<=1000; j++){
                if(((3*i)+(5*j))==N){
                    count=i+j;
                    if(mincount!=0 && mincount>count)
                        mincount=count;
                    else if(mincount==0)
                        mincount=count;
                }
            }
        }
        if(count==0)
            System.out.print(-1);
        else 
            System.out.print(mincount);
    }
}
