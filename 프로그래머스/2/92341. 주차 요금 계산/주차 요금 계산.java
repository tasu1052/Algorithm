import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        //누적 주차 시간이 기본 시간 이하면 기본요금
        //초과 시 기본 요금 + 초과 시간에 대해 단위 시간 단위 요금 청구
        //records 순회하면서 in이면 set에 넣고 out이면 set에서 빼면서 treemap에 누적 요금 저장
        //만약 out 없이 끝까지 set에 남으면 그거 23:59로 시간 계산 이렇게 하면 될듯?
        //fee[0] = 기본 시간, fee[1] = 기본 요금, fee[2] = 단위 시간, fee[3] = 단위 요금
        //records -> 시각, 차량번호, 내역
        HashSet<String[]> parking = new HashSet<>();
        TreeMap<Integer, Integer> fee = new TreeMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] log = records[i].split(" "); //시각, 차량번호, 내역
            
            if(log[2].equals("IN")){ //입차인 경우
                parking.add(new String[]{log[0], log[1]}); //시각, 차량번호
            }
            
            if(log[2].equals("OUT")){ //차가 출차하는 경우
                int inTime = 0;
                for(String[] s : parking){
                    if(s[1].equals(log[1])){
                        String[] tmp = s[0].split("\\:");
                        inTime = Integer.valueOf(tmp[0]) * 60 + Integer.valueOf(tmp[1]);
                        break;
                    }
                }
                String[] tmp = log[0].split("\\:"); //:로 쪼개서 분으로 변환
                int outTime = Integer.valueOf(tmp[0]) * 60 + Integer.valueOf(tmp[1]);
                
                int totalTime = outTime - inTime;
                
                fee.put(Integer.valueOf(log[1]), fee.getOrDefault(Integer.valueOf(log[1]), 0) + totalTime);
                
                parking.removeIf(s -> s[1].equals(log[1]));
            }
        }
        
        for(String[] s : parking){
            String[] time = s[0].split("\\:");
            int inTime = Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
            int outTime = 23 * 60 + 59;
            
            int totalTime = outTime - inTime;
            fee.put(Integer.valueOf(s[1]), fee.getOrDefault(Integer.valueOf(s[1]), 0) + totalTime);
        }
        
        int[] answer = new int[fee.size()];
        
        int idx = 0;
        for(int key : fee.keySet()){
            int culTime = fee.get(key);
            if(culTime > fees[0]){
                answer[idx] = fees[1] + (int)Math.ceil((double)(culTime - fees[0]) / fees[2]) * fees[3];
            }
            else{
                answer[idx] = fees[1];
            }
            idx++;
        }
        return answer;
    }
}