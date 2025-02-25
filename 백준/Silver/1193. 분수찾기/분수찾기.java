import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int X = Integer.parseInt(br.readLine());
        
        int count = 0;
        int n = 1;
        int i = 0;
        int num = 1;
        int den = 1;
        
        while(count<X){
            count += n;
            n = n + 1;
            i++;
        }
           
        if(i==1)
            System.out.print(num + "/" + den);
        else{
                if(i%2==1){
                    den=i;
                    for(int j=0; j<count-X;j++){
                        den--;
                        num++;
                    }
                    System.out.print(num + "/" + den);
                }
                else{
                    num=i;
                    for(int j=0; j<count-X;j++){
                        den++;
                        num--;
                    }
                    System.out.print(num + "/" + den);
                }
            }
    }
}