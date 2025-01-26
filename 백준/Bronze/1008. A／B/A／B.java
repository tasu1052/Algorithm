import java.util.Scanner;

public class Main{
    public static void main(String[] argc){
        Scanner in= new Scanner(System.in);
        double A = in.nextInt();
        double B = in.nextInt();
        
        in.close();
        System.out.print(A/B);
    }
}