class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]) swap(sizes, i);
            
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }
        
        int answer = maxW * maxH;
        
        return answer;
    }
    public void swap(int[][] arr,int idx){
        int tmp = arr[idx][0];
        arr[idx][0] = arr[idx][1];
        arr[idx][1] = tmp;
    }
}