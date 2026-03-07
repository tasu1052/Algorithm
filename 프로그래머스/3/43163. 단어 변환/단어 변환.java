class Solution {
    static boolean[] selected;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        selected = new boolean[words.length];
        boolean check = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                check = true;
                break;
            }
        }
        
        if(check) dfs(0, 0, begin, target, words);
        else answer = 0;
        
        return answer;
    }
    static void dfs(int idx, int cnt, String cur, String target, String[] words){
        if(cur.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(cnt >= answer) return;
        
        for(int i=0; i<words.length; i++){
            if(selected[i]) continue;
            
            int n = 0;
            for(int j=0; j<cur.length(); j++){
                if(cur.charAt(j) == words[i].charAt(j)) n++;
            }
            if(n == cur.length() - 1){
                selected[i] = true;
                dfs(idx + 1, cnt + 1, words[i], target, words);
                selected[i] = false;
            }
        }
    }
}