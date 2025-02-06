import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        
        String[] S = new String[10000000];
        int index = 0;
        while(st.hasMoreTokens()){
            S[index] = st.nextToken();
            index++;
        }
        System.out.print(index);
        
    }
}