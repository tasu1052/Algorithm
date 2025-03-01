import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] x = new int[3];
        int[] y = new int[3];
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        x[0] = Integer.parseInt(st1.nextToken());
        y[0] = Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        x[1] = Integer.parseInt(st2.nextToken());
        y[1] = Integer.parseInt(st2.nextToken());
        
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        x[2] = Integer.parseInt(st3.nextToken());
        y[2] = Integer.parseInt(st3.nextToken());
        
        int minx=x[0];
        int miny=y[0];
        
        for(int i=1; i<3;i++){
            if(minx>x[i])
                minx=x[i];
            if(miny>y[i])
                miny=y[i];
        }
        
        int diff1=0;
        int count1=0;
        int count2=0;
        
        for(int i=0; i<3; i++){
            if(x[i]-minx!=0){
                diff1=x[i]-minx;
                count1++;
            }
            else{
                count2++;
            }
        }
        if(count1<count2){
            System.out.print(minx+diff1 + " ");
            }
        else{
            System.out.print(minx+ " ");
            }
        
        int diff2=0;
        int count3=0;
        int count4=0;
        
        for(int i=0; i<3; i++){
            if(y[i]-miny!=0){
                diff2=y[i]-miny;
                count3++;
            }
            else{
                count4++;
            }
        }
        if(count3<count4){
            System.out.print(miny+diff2);
            }
        else{
            System.out.print(miny);
            }
        
    
        
    }
}