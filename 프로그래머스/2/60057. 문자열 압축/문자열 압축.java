class Solution {
    public int solution(String s) {
        //substring으로 자르고
        //int로 몇개씩 자를지 정해놓고
        //for문 순회하면서 이전꺼랑 같은지 확인 후
        //같으면 cnt++ 아니라면 지금까지 cnt++한거 반영한 문자열 만들기
        
        int ans = s.length();
        for(int len=1; len<=s.length() / 2; len++){//얼마의 크기로 자르는지 순회
            StringBuilder sb = new StringBuilder();
            int idx = len;
            int cnt = 1;
            String prev = s.substring(0, len);
            while(idx < s.length() && idx + len <= s.length()){//해당 크기로 s자르기
                String cur = s.substring(idx, idx + len);
                if(cur.equals(prev)){//현재 문자열이 전꺼와 같으면
                    cnt++;
                }
                else{//다르다면 지금까지의 cnt sb에 저장해놓고 거기부터 시작
                    if(cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = cur;
                    cnt = 1;
                }
                idx += len;
            }
            if(cnt > 1) sb.append(cnt);
            sb.append(prev);
            
            sb.append(s.substring(idx));
            ans = Math.min(ans, sb.length());
        }

        return ans;
    }
}