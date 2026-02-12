import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
       	st = new StringTokenizer(br.readLine());
       	int gukSum = 0;
       	
       	for(int i=0; i<4; i++) {
       		gukSum += Integer.parseInt(st.nextToken());
       	}
       	
       	st = new StringTokenizer(br.readLine());
       	int manSum = 0;
       	
       	for(int i=0; i<4; i++) {
       		manSum += Integer.parseInt(st.nextToken());
       	}
       	
       	if(gukSum >= manSum) System.out.println(gukSum);
       	else System.out.println(manSum);   
    }
}