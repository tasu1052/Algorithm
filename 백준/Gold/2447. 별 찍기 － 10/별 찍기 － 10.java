import java.io.*;
import java.util.*;

public class Main {
    static char[][] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        c = new char[N][N];
        for(int i=0; i<c.length; i++)
            Arrays.fill(c[i], '*');

        star(0, 0, N);

        for(int i=0; i<c.length; i++)
            System.out.println(new String(c[i]));
        }
    
    static void star(int x, int y, int size){
        if(size==1) return;

        int third = size / 3;

        for(int i=x + third; i<x + 2*third; i++){
            for(int j=y + third; j<y + 2*third; j++){
                c[i][j] = ' ';
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                star(x + i*third, y+j*third, third);
            }
        }
    }
}