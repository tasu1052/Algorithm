import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st;

        String s = br.readLine();

        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if(c == ')'){
                if(st.isEmpty()) st.push(c);
                else if(st.peek() == '(') st.pop();
                else st.push(c);
            }
        }

        System.out.print(st.size());
    }
}