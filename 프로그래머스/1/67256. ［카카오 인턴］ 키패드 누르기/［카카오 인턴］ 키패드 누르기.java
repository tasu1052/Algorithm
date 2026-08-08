import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        //1, 4, 7은 왼손 3, 6, 9는 오른손
        //2, 5, 8, 0은 더 가까운 손 거리 같으면 주 손 선택
        //2차원 배열 만들어서 현재 손가락 위치 정보 저장하고 numbers 배열 숫자마다 그거 반영하면 되지 않을까?
        StringBuilder sb = new StringBuilder();

        int lx = 3, ly = 0;
        int rx = 3, ry = 2;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                
                lx = (numbers[i] - 1) / 3;
                ly = (numbers[i] - 1) % 3;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                
                rx = (numbers[i] - 1) / 3;
                ry = (numbers[i] - 1) % 3;
            }
            else{
                int mx = -1, my = -1;
                
                mx = (numbers[i] - 1) / 3;
                my = (numbers[i] - 1) % 3;
                
                if(numbers[i] == 0) mx = 3; my = 1;
                
                int leftDis = cal(lx, ly, mx, my);
                int rightDis = cal(rx, ry, mx, my);
                
                if(leftDis > rightDis){
                    sb.append("R");
                    rx = mx; ry = my;
                }
                else if(leftDis < rightDis){
                    sb.append("L");
                    lx = mx; ly = my;
                }
                else{
                    if(hand.equals("left")) {
                        sb.append("L");
                        lx = mx; ly = my;
                    }
                    else if(hand.equals("right")) {
                        sb.append("R");
                        rx = mx; ry = my;
                    }
                }
            }
        }
        return sb.toString();
    }
    static int cal(int sx, int sy, int ex, int ey){
        return Math.abs(sx - ex) + Math.abs(sy - ey);
    }
}