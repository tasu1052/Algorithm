class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                sb.append(c);
                idx = 0;
            }
            else{
                if(idx % 2 == 0){
                    c = Character.toUpperCase(c);
                    sb.append(c);
                }
                else{
                    c = Character.toLowerCase(c);
                    sb.append(c);
                }
                idx++;
            }
            
        }

        return sb.toString();
    }
}