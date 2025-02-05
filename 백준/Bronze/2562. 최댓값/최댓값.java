import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        String input;
        while((input = br.readLine()) != null && !input.isEmpty()){
            list.add(Integer.parseInt(input));
        }
        if(list.isEmpty())
                return;
        
        int max =list.get(0);
        int index=0;
      
        for(int i=1; i<list.size(); i++){
            if(max < list.get(i)){
                max = list.get(i);
                index=i;
            
            }
            
        }
        System.out.println(max);
        System.out.print(index+1);
        
    }
}