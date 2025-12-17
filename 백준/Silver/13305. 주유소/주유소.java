import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] road = new int[N-1];
        st = new StringTokenizer(br.readLine());
        long maxLength = 0;
        for(int i=0; i<N-1; i++){
            road[i] = Integer.parseInt(st.nextToken());
            maxLength += road[i];
        }
        
        int[] city = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) city[i] = Integer.parseInt(st.nextToken());

        long cost = 0;
        long length = 0;

        int cityIdx = 0;
        int roadIdx = 0;
        while(cityIdx != N-1){
            if(city[cityIdx] > city[cityIdx + 1]){
                cost += city[cityIdx] * road[roadIdx];
                cityIdx++;
                roadIdx++;
            }
            else{
                int tmpLength = 0;
                int curCityIdx = cityIdx;
                cityIdx++;
                while(city[curCityIdx] < city[cityIdx]){
                    tmpLength += road[roadIdx++];
                    cityIdx++;
                }
                tmpLength += road[roadIdx++];
                cost += city[curCityIdx] * tmpLength;
            }
        }
        System.out.print(cost);
    }
}