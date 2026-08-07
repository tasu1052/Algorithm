class Solution {
    public int solution(int number, int limit, int power) {
        int iron = 0;
        for(int i=1; i<=number; i++){
            int cnt = 0;
            for(int j=1; j<=i; j++){
                if(i % j == 0){
                    cnt++;
                }
            }
            
            if(cnt > limit){
                iron += power;
            }
            else{
                iron += cnt;
            }
        }

        return iron;
    }
}