import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergesort(A, 0, N-1, K);
        System.out.println(result);
    }
    static void mergesort(int[] a, int p, int r, int k){
        if(p < r){
            int q = (int)Math.floor(((p+r)/2));
            mergesort(a, p, q, k);
            mergesort(a, q+1, r, k);
            merge(a, p, q, r, k);
        }
    }
    static void merge(int[] a, int p, int q, int r, int k){
        int i = p;
        int j = q+1;
        int t = 0;
        int[] tmp = new int[r-p+1];
        
        while(i<=q && j<=r){
            if(a[i]<=a[j]){
                tmp[t++] = a[i++];
            }
            else{
                tmp[t++] = a[j++];
            }
            cnt++;
            if(cnt == k){
                result = tmp[t-1];
            }
        }
        while(i<=q){
            tmp[t++] = a[i++];
            cnt++;
            if(cnt == k){
                result = tmp[t-1];
            }
        }
        while(j<=r){
            tmp[t++] = a[j++];
            cnt++;
            if(cnt == k){
                result = tmp[t-1];
            }
        }
        i = p;
        t = 0;
        while(i<=r)
            a[i++] = tmp[t++];
    }
}