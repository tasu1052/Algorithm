import java.io.*;
import java.util.*;

public class Main {
    static int[] color;
    static ArrayList<Integer>[] A;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        long cnt = 0;
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;

        while(left < right){
            if((arr[left] + arr[right]) > x) right--;
            else if((arr[left] + arr[right]) < x) left++;
            else{
                cnt++;
                left++;
                right--;
            }
        }
        System.out.print(cnt);
    }
}