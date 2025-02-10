import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] sub = new String[20];
        double[] gra = new double[20];
        double[] num = new double[20];
        double sumgra = 0.0;
        double sum = 0.0;
        double avg = 0.0;
        
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            
            sub[i] = st.nextToken();
            gra[i] = Double.parseDouble(st.nextToken());
            num[i] = rank(st.nextToken());
            
            if(num[i] == -1.0)
                continue;
            
            sumgra += gra[i];
                
            
            sum += (gra[i] * num[i]);
        }
        
        avg = (sumgra == 0) ? 0.0 : sum/sumgra;
        
        System.out.printf("%.6f", avg);
    }
    public static double rank(String S) throws IOException{
        if(S.equals("A+"))
            return 4.5;
        else if(S.equals("A0"))
            return 4.0;
        else if(S.equals("B+"))
            return 3.5;
        else if(S.equals("B0"))
            return 3.0;
        else if(S.equals("C+"))
            return 2.5;
        else if(S.equals("C0"))
            return 2.0;
        else if(S.equals("D+"))
            return 1.5;
        else if(S.equals("D0"))
            return 1.0;
        else if(S.equals("F"))
            return 0.0;
        else if(S.equals("P"))
            return -1.0;
        return -1.0;
    }
}