import java.util.*;
import java.io.*;

class Main {
    static int[] arr, tmp;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        result = 0;
        mergeSort(0, N-1);
        
        System.out.print(result);
    }
    static void mergeSort(int s, int e){
        if(e - s < 1) return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i=s; i<=e; i++) tmp[i] = arr[i];

        int k = s;
        int idx1 = s;
        int idx2 = m+1;
        while(idx1 <= m && idx2 <= e){
            if(tmp[idx1] > tmp[idx2]){
                arr[k] = tmp[idx2];
                result = result + idx2 - k;
                k++;
                idx2++;
            }
            else{
                arr[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while(idx1 <= m){
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while(idx2 <= e){
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}