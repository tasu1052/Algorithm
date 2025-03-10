import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = S.charAt(j);
            }
        }

        int minCount = 64;
        
        for (int row = 0; row + 8 <= N; row++) {
            for (int col = 0; col + 8 <= M; col++) {
                int countB = 0;
                int countW = 0; 

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (arr[row + i][col + j] != 'B') countB++;  
                            if (arr[row + i][col + j] != 'W') countW++;
                        } else {
                            if (arr[row + i][col + j] != 'W') countB++;
                            if (arr[row + i][col + j] != 'B') countW++;
                        }
                    }
                }
                minCount = Math.min(minCount, Math.min(countB, countW));
            }
        }

        System.out.println(minCount);
    }
}
