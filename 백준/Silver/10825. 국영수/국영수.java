import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Student> q = new PriorityQueue<>((a, b) ->{
            if(a.KoreanScore != b.KoreanScore) 
                return -Integer.compare(a.KoreanScore, b.KoreanScore);
            
            if(a.EnglishScore != b.EnglishScore)
                return Integer.compare(a.EnglishScore, b.EnglishScore);
            
            if(a.MathScore != b.MathScore)
                return -Integer.compare(a.MathScore, b.MathScore);
            
            return a.name.compareTo(b.name);
        });
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int KoreanScore = Integer.parseInt(st.nextToken());
            int EnglishScore = Integer.parseInt(st.nextToken());
            int MathScore = Integer.parseInt(st.nextToken());

            q.add(new Student(name, KoreanScore, EnglishScore, MathScore));
        }

        while(!q.isEmpty()) sb.append(q.poll().name).append('\n');
        
        System.out.print(sb);
        
    }
}
class Student{
    String name;
    int KoreanScore;
    int EnglishScore;
    int MathScore;

    Student(String name, int KoreanScore, int EnglishScore, int MathScore){
        this.name = name;
        this.KoreanScore = KoreanScore;
        this.EnglishScore = EnglishScore;
        this.MathScore = MathScore;
    }
}
