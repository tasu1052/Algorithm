import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        Character[] arr = new Character[s.length()];
        for(int i=0; i<s.length(); i++) arr[i] = s.charAt(i);

        Arrays.sort(arr, (a, b) -> b - a);


        for(Character c : arr) sb.append(c);
        System.out.print(sb);
    }
}
