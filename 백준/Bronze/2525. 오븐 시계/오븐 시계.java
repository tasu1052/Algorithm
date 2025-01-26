import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        
        int C = in.nextInt();
        
        in.close();
        
        int min = 60 * A + B + C;
        A = min / 60;
        B = min % 60;
        if(A>=24)
            A = A % 24;
        System.out.print(A + " " + B);
        
    }
}