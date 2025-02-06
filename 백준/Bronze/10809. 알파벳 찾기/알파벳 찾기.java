import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int[] arr = new int[26];
        
        for(int i=0; i<arr.length;i++)
            arr[i] = -1;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(arr[c-97] == -1)
                arr[c-97] = i;
        }
        
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}