import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        String lit="";
        for(int i=0; i<(N/4); i++)
            lit += "long ";
        System.out.print(lit + "int");
    }
}