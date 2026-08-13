class Solution {
    public int solution(int n, int m, int[] section) {
        int idx = 0;
        int answer = 0;

        while(idx < section.length) {
            int end = section[idx] + m;

            while(idx < section.length && section[idx] < end) {
                idx++;
            }

            answer++;
        }

        return answer;
    }
}