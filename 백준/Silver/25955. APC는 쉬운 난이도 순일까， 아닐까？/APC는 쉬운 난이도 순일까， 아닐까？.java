import java.io.*;
import java.util.*;

public class Main {
	static int tierRank(char c) {
		switch (c) {
        case 'B': return 0;
        case 'S': return 1;
        case 'G': return 2;
        case 'P': return 3;
        case 'D': return 4;
        default:  return 99;
    }
}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        Level[] original = new Level[N];
        
        for(int i=0; i<N; i++) {
        	String s = st.nextToken();
        	char t = s.charAt(0);
        	int n = Integer.parseInt(s.substring(1));
        	original[i] = new Level(t, n, s);
        }
        
        Level[] b = original.clone();
        Arrays.sort(b, (x, y) -> {
        	int rx = tierRank(x.tier);
        	int ry = tierRank(y.tier);
        	if(rx != ry) return Integer.compare(rx, ry);
        	return -Integer.compare(x.num, y.num);
        });
        
        ArrayList<Integer> diff = new ArrayList<>();
        for(int i=0; i<N; i++) {
        	if(!original[i].raw.equals(b[i].raw)) diff.add(i);
        }
        
        if(diff.isEmpty()) System.out.println("OK");
        else {
        	int i1 = diff.get(0), i2 = diff.get(1);
        	System.out.println("KO");
        	System.out.println(b[i1].raw + " " + b[i2].raw);
        }
    }
}

class Level{
	char tier;
	int num;
	String raw;
	
	Level(char tier, int num, String raw){
		this.tier = tier;
		this.num  = num;
		this.raw = raw;
	}
}