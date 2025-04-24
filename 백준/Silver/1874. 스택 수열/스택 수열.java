import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int index = 1;
        int arrindex = 0;
        
        while (index<=n) {
            st.push(index);
            sb.append("+").append('\n');
            if(st.peek()==arr[arrindex]){
                st.pop();
                sb.append("-").append('\n');
                arrindex++;
                while(!st.isEmpty()){
                    if(st.peek()==arr[arrindex]){
                        st.pop();
                        sb.append("-").append('\n');
                        arrindex++;
                    }
                    else
                        break;
                }
            }
            index++;
        }
        if(arrindex==n) System.out.print(sb);
        else System.out.print("NO");
    }
}