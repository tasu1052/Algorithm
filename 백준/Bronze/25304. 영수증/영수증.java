import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        
        int N = in.nextInt();
        
        int sum=0;
        
        for(int i=0;i<N;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            sum += a*b;
        }
        
        if(X==sum)
            System.out.print("Yes");
        else
            System.out.print("No");
            
        in.close();
        
    }
}