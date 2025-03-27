import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        
        String[][] str = new String[n][2];
        for(int i=0; i<n; i++){
            String S = br.readLine();
            str[i] = S.split(" ");
        }
        
        for(int i=0; i<n; i++){
            if(str[i][1].equals("enter"))
                hs.add(str[i][0]);
            else
                hs.remove(str[i][0]);
        }
        
        String[] human = hs.toArray(new String[0]);
        
        Arrays.sort(human);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<human.length; i++){
            sb.append(human[human.length -1 -i]).append('\n');
        }
        
        System.out.print(sb);
    }
}