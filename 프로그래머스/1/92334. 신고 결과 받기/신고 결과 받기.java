import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //해시셋에 중복 없애는거 넣고
        //해시맵에 유저 별 신고 횟수 저장해서 기준 넘으면 그 유저 신고한 사람들에게 메일 발송
        HashSet<String> log = new HashSet<>();
        HashMap<String, Integer> reportCnt = new HashMap<>();
        
        int[] ans = new int[id_list.length];
        
        for(int i=0; i<report.length; i++){
            if(log.contains(report[i])) continue;
            
            log.add(report[i]);
            String[] tmp = report[i].split(" ");
            reportCnt.put(tmp[1], reportCnt.getOrDefault(tmp[1], 0) + 1);
        }
        
        for(String s : log){
            String[] tmp = s.split(" ");
            
            if(reportCnt.get(tmp[1]) >= k){
                for(int i=0; i<id_list.length; i++){
                    if(id_list[i].equals(tmp[0])){
                        ans[i]++;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}