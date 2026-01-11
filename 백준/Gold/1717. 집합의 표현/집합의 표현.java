import java.io.*;
import java.util.*;

public class Main{
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<n+1; i++) arr[i] = i;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(com == 0){
                union(a, b);
            }
            else{
                if(find(a) == find(b)) sb.append("YES\n");
                else sb .append("NO\n");
            }
        }
        System.out.print(sb);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) arr[b] = a;
    }
    static int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
}