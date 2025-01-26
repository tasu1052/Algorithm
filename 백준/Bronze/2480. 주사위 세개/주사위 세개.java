import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        
        in.close();
        
        int max;
        
        if(A>B)
            max = A;
        else
            max = B;
        
        if(max < C)
            max = C;
            
        
        if(A==B){
            if(B==C)
                System.out.print(10000 + A * 1000);
            else
                System.out.print(1000 + A * 100);
        }
        else {
            if(B==C)
                System.out.print(1000 + B * 100);
            else if(A==C)
                System.out.print(1000 + A * 100);
            else
                System.out.print(max * 100);
                
        }
            
    }
}