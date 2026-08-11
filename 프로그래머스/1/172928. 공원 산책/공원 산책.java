class Solution {
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(String[] park, String[] routes) {
        //park를 이차원 배열로 전처리하고
        //루트 명령 순회하면서 공원 벗어나가서 장애물 만나면 continue
        int x = -1, y = -1;
        char[][] map = new char[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    x = i; y = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String[] tmp = routes[i].split(" ");
            int dir = -1;
            if(tmp[0].equals("N")){
                dir = 0;
            }
            else if(tmp[0].equals("S")){
                dir = 1;
            }
            else if(tmp[0].equals("W")){
                dir = 2;
            }
            else{
                dir = 3;
            }
            int cnt = Integer.parseInt(tmp[1]);
            
            int nx = x, ny = y;
            boolean flag = true;
            for(int j=0; j<cnt; j++){
                nx += dx[dir]; ny += dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    flag = false;
                    break;
                }
                if(map[nx][ny] == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                x = nx; y = ny;
                System.out.println("x=" + x + "y=" + y);
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
}