import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> visited = new HashSet<>();
        
        int x = 5, y = 5;
        
        for(int i=0; i<dirs.length(); i++){
            char com = dirs.charAt(i);
            int dir = 0;
            
            if(com == 'U'){
                dir = 0;
            }
            else if(com == 'D'){
                dir = 1;
            }
            else if(com == 'R'){
                dir = 2;
            }
            else{
                dir = 3;
            }
            
            int nx = x + dx[dir];
            int ny = y + dy[dir];
                
            if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11){
                continue;
            }
                
            String path = x + "," + y + "," + nx + "," + ny;
            String reverse = nx + "," + ny + "," + x + "," + y;
            
            if(!visited.contains(path)){
                visited.add(path);
                visited.add(reverse);
                answer += 1;
            }
                
            x = nx; y = ny;
            
        }
        return answer;
    }
}