import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if(N>1){
            int count=1;
            int prev_digit=0;
            int num=0;
            
            while(true){
                if((prev_digit%10000)/10==666 && prev_digit%10!=6){
                    for(int i=0; i<1000;i++){
                        if(count==N){
                            System.out.print(prev_digit*1000+num);
                            return;
                        }
                        num++;
                        count++;
                    }
                    prev_digit++;
                }
                
                else if(prev_digit%1000==666){
                    num=0;
                    for(int i=0;i<1000;i++){
                        if(count==N){
                            System.out.print(prev_digit*1000+num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    prev_digit++;
                }
                
                else if(prev_digit%100==66){
                    num=600;
                    for(int i=0; i<100; i++){
                        if(count==N){
                            System.out.print(prev_digit*1000+num);
                            return;
                        }
                        count++;
                        num++;
                    }
                    prev_digit++;
                }
                
                else if(prev_digit%10==6){
                    num=660;
                    for(int i=0; i<10; i++){
                        if(count==N){
                            System.out.print(prev_digit*1000+num);
                            return;
                        }
                        num++;
                        count++;
                    }
                    prev_digit++;
                }
                
                else{
                    num=666;
                    if(count==N){
                        System.out.print(prev_digit*1000+num);
                        return;
                    }
                    count++;
                    prev_digit++;
                }
            }
        }
        
        else
            System.out.println(666);
    }
}