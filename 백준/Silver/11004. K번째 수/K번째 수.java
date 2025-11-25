import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        quicksort(arr, 0, N-1, K-1);
        System.out.print(arr[K-1]);
    }
    static void quicksort(int[] arr, int start, int end, int k){
        if(start<end){
            int pivot = partition(arr, start, end);
            if(pivot == k) return;
            else if(k<pivot) quicksort(arr, start, pivot-1, k);
            else quicksort(arr, pivot+1, end, k);
        }
    }
    static int partition(int[] arr, int s, int e){
        if(s+1 == e){
            if(arr[s]>arr[e]) swap(arr, s, e);
            return e;
        }
        int M = (s + e) / 2;
        swap(arr, s, M);
        int pivot = arr[s];
        int i = s+1, j = e;
        while(i<=j){
            while(j >= s+1 && pivot < arr[j]){
                j--;
            }
            while(i <= e && pivot > arr[i]){
                i++;
            }
            if(i <= j){
                swap(arr, i++, j--);
            }
        }
        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}