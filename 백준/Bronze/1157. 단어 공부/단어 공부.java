import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        char[] ch = S.toCharArray();
        
        int[] arr = new int[26];
        
        for(int i=0; i<26; i++)
            arr[i] = 0;
        
        for(int i=0; i<ch.length; i++){
            for(char j='a'; j<='z'; j++){
                if(ch[i]==j)
                    arr[j-'a'] += 1;
            }    
        }
        
        for(int i=0; i<ch.length; i++){
            for(char j='A'; j<='Z'; j++){
                if(ch[i]==j)
                    arr[j-'A'] += 1;
            }    
        }
        
        int max = arr[0];
        int maxindex = 0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                maxindex = i;
            }
        }

        int count=0;

        for(int i=0; i<arr.length; i++){
            if(max==arr[i]){
                count++;
            }
        }
        if(count<=1)
                System.out.print((char)(maxindex+65));
        else
                System.out.print("?");
    }
}