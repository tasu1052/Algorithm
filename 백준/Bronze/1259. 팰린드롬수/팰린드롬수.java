import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int N = Integer.parseInt(br.readLine());
            String S = Integer.toString(N);
            int[] arr = new int[S.length()];
            
            for(int i=0; i<S.length(); i++){
                arr[i] = S.charAt(i) - '0';
            }
            boolean check = true;
            
            if(arr[0]==0)
                break;
            
            for(int i=0; i<(arr.length/2); i++){
                if(arr[i]==arr[arr.length-1 -i])
                    check = true;
                else{
                    check = false;
                    break;
                    }
                }
            
            if(check==true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
        
    }
}
