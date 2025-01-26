import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        sc.close();
        
        int S1 = B/100;
        int S2= (B%100)/10;
        int S3= B%10;
        
        System.out.println(A*S3);
        System.out.println(A*S2);
        System.out.println(A*S1);
        System.out.println(A*B);
        
    }
}