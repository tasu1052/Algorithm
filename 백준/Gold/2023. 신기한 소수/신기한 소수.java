import java.util.*;
import java.io.*;

class Main {
    static ArrayList<Integer>[] A;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());

        A = new ArrayList[11];
        for(int i=0; i<11; i++) A[i] = new ArrayList<Integer>();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.print(sb);
    }
    static void dfs(int v, int level){
        int jaritsu = 10;
        if(N == level){
            sb.append(v).append('\n');
            return;
        }
        for(int i=0; i<=9; i++){
            if(isPrime((v*jaritsu) + i)){
                dfs(v*jaritsu + i, level + 1);
            }
        }
    }
    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}