import java.util.*;
import java.io.*;

class Solution {
    static int x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            // 입력 공백 줄 무시
            String line;
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            st = new StringTokenizer(line);
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                while (s != null && s.length() < W) s = br.readLine(); // 빈줄 방지
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    if ("^v<>".indexOf(Character.toLowerCase(map[i][j])) != -1) {
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine().trim());
            String command = br.readLine().trim();

            for (int i = 0; i < N; i++) {
                char c = command.charAt(i);
                if (c == 'S') shoot(map, H, W);
                else move(map, c, H, W);
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    static void move(char[][] map, char c, int h, int w) {
        if (c == 'U') {
            map[x][y] = '^';
            if (x - 1 >= 0 && map[x - 1][y] == '.') {
                map[x][y] = '.';
                x--;
                map[x][y] = '^';
            }
        } else if (c == 'D') {
            map[x][y] = 'v';
            if (x + 1 < h && map[x + 1][y] == '.') {
                map[x][y] = '.';
                x++;
                map[x][y] = 'v';
            }
        } else if (c == 'L') {
            map[x][y] = '<';
            if (y - 1 >= 0 && map[x][y - 1] == '.') {
                map[x][y] = '.';
                y--;
                map[x][y] = '<';
            }
        } else if (c == 'R') {
            map[x][y] = '>';
            if (y + 1 < w && map[x][y + 1] == '.') {
                map[x][y] = '.';
                y++;
                map[x][y] = '>';
            }
        }
    }

    static void shoot(char[][] map, int h, int w) {
        if (map[x][y] == '^') {
            for (int i = x - 1; i >= 0; i--) {
                if (map[i][y] == '#') break;
                if (map[i][y] == '*') { map[i][y] = '.'; break; }
            }
        } else if (map[x][y] == 'v') {
            for (int i = x + 1; i < h; i++) {
                if (map[i][y] == '#') break;
                if (map[i][y] == '*') { map[i][y] = '.'; break; }
            }
        } else if (map[x][y] == '<') {
            for (int j = y - 1; j >= 0; j--) {
                if (map[x][j] == '#') break;
                if (map[x][j] == '*') { map[x][j] = '.'; break; }
            }
        } else if (map[x][y] == '>') {
            for (int j = y + 1; j < w; j++) {
                if (map[x][j] == '#') break;
                if (map[x][j] == '*') { map[x][j] = '.'; break; }
            }
        }
    }
}
