import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long C = in.nextLong();
        in.close();
        
        System.out.print(A+B+C);
    }    
}