import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        if(A.equals("1")){
            if(B.equals("2")){
                System.out.print("B");
            }
            else{
                System.out.print("A");
            }
        }
        if(A.equals("2")){
            if(B.equals("3")){
                System.out.print("B");
            }
            else{
                System.out.print("A");
            }
        }
        if(A.equals("3")){
            if(B.equals("1")){
                System.out.print("B");
            }
            else{
                System.out.print("A");
            }
        }
    }
}