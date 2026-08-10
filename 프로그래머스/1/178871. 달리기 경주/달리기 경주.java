import java.util.*;
class Solution {
    static HashMap<String, Integer> rank = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        //맵으로 순위 저장해놓고 맵 안에서 순위 바꾸는 식으로 하면 될거 같은데
        for(int i=0; i<players.length; i++){
            rank.put(players[i], i+1);
        }
        for(int i=0; i<callings.length; i++){
            swap(players, callings[i]);
        }
        return players;
    }
    static void swap(String[] players, String who){
        int cur = rank.get(who) - 1; //이름 불린 사람 순위
        int prev = cur - 1; //이름 불린 사람 앞 순위 
        String tmp = players[cur];
        players[cur] = players[prev];
        players[prev] = tmp;
        
        rank.put(players[prev], prev + 1);
        rank.put(players[cur],cur + 1);
    }
}