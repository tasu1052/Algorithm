import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] op = new double[n];

        for(int i=0; i<n; i++)
            op[i] = Integer.parseInt(br.readLine());
        Arrays.sort(op);
        
        int rmv = (int)Math.round(n * 0.15);
        double sum = 0;
        for(int i=rmv; i<n-rmv; i++){
            sum += op[i];
        }
        int avg = (int)Math.round(sum/(n-2*rmv));
        System.out.print(avg);
    }
}