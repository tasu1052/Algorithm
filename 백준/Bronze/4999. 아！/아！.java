import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String my = br.readLine();

        int myCnt = my.length() - 1;
        
        String doctor = br.readLine();

        int doctorCnt = doctor.length() - 1;

        if(myCnt >= doctorCnt) System.out.print("go");
        else System.out.print("no");
    }
}