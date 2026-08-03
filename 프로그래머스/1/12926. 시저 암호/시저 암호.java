class Solution {
    public String solution(String s, int n) {
        //StringBuilder 선언하고
        //문자열 s를 charAt해서 하나씩 덧셈 연산으로 밀어낸다
        //이때 26을 넘어가면 %연산으로 다시 0으로 돌린다
        //그리고 스트링빌더에 하나씩 append한 뒤 toString 한다
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c >= 'a' && c <= 'z'){
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            else if(c >= 'A' && c <= 'Z'){
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }
            
            sb.append(c);
        }

        return sb.toString();
    }
}