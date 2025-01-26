import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int H = in.nextInt();
        int M = in.nextInt();
        
        in.close();
        
        if(M-45>=0)
            System.out.print(H + " " + (M-45));
        else{ 
            if(H==0){
                H=23;
                System.out.print(H + " " +(60-(45-M)));
            }
            else
                System.out.print((H-1) + " " + (60-(45-M)));
            
             
        }
        
    }
}