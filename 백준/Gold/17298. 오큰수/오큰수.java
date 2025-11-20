import java.io.*;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer ST = new StringTokenizer(br.readLine());
        Stack<Integer> st = new Stack<>();
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(ST.nextToken());

        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        st.push(0);
        for(int i=1; i<N; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        /*
        while(!st.isEmpty()){
            ans[st.pop()] = -1;
        }
*/
        for(int i=0; i<N; i++) sb.append(ans[i] + " ");
        
        System.out.print(sb);
    }
}