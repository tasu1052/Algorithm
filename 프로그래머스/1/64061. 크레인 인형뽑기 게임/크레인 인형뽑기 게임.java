import java.util.*;

class Solution {
    static int cnt = 0;
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    public int solution(int[][] board, int[] moves) {
        //pick 함수로 인형 뽑기 구현(세로)
        //스택으로 같은 모형 인형 두개 터지는거 구현
        
        for(int i=0; i<moves.length; i++){
            //뽑기 위치 배열 순회하면서 인형 뽑기 이때 1-index를 0-index로 전환
            pick(board, moves[i] - 1);
        }
        return cnt;
    }
    static void pick(int[][] board, int start){
        //start 위치 즉 열을 고정하고 행을 위부터(0부터) 아래로 내려가면서
        //인형 있으면 집어서 주머니에 넣기
        for(int i=0; i<board.length; i++){
            if(board[i][start] != 0){
                tryPut(board[i][start]);
                board[i][start] = 0;
                break;
            }
        }
    }
    static void tryPut(int target){
        //주머니에 아무것도 없으면 그냥 넣고
        //하나라도 있으면 맨위에 인형과 현재 넣을 것 비교해서
        //같은거면 폭발하고 카운트 증가
        if(q.size() == 0) {
            q.push(target);
            return;
        }
        
        if(q.peek() == target){
            q.pop();
            cnt += 2;
        }
        else{
            q.push(target);
        }
        return;
    }
}