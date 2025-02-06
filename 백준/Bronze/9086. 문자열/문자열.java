import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            String str = br.readLine();
            String[] S = str.split("");
            
            System.out.print(S[0]);
            System.out.println(S[S.length-1]);
            
        }
    }
}