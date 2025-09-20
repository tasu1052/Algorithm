import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min =  Integer.MAX_VALUE;
        
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        InsertOp(1, arr[0]);

        System.out.println(max);
        System.out.print(min);
    }

    static void InsertOp(int idx, int sum) {
        if (idx == N) {
            if(sum>max){
                max = sum;
            }
            if(sum<min){
                min = sum;
            }
            return;
        }

        for (int j = 0; j < op.length; j++) {
            if (op[j] != 0) {
                op[j] = op[j] - 1;
                int newsum = select(sum, arr[idx], j);
                InsertOp(idx+1, newsum);
                op[j] = op[j] + 1;
            }
        }
    }

    static int select(int sum, int next, int num) {
        if (num == 0) return sum + next;
        else if (num == 1) return sum - next;
        else if (num == 2) return sum * next;
        else {
            if(sum>0){
                return sum / next; 
            }
            else{
                return -(-sum / next);
            }
        }
    }
}
