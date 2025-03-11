import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int count=0;
        int index=666;
        while(true){
            String S = Integer.toString(index);
            if(S.contains("666")){
                count++;
            }
            if(count==N){
                System.out.print(index);
                break;
            }
            index++;
        }  
    }
}
