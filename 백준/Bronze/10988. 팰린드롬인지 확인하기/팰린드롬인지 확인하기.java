import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t;
        String S = br.readLine();
        String[] str = S.split("");
        String[] reverse = str.clone();
        
        int i=0;
        int j=str.length-1;
        String temp;
        
        while(i<j){
            temp=str[j];
            str[j] = str[i];
            str[i]=temp;
            i++;
            j--;
        }
        
        if(Arrays.equals(str, reverse))
            System.out.print(1);
        else
            System.out.print(0);
        
    }
}
