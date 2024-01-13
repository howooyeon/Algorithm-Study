class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(n % 7 == 0){
                answer = (n/7);
            } else {
                answer = (n/7) + 1; 
            }
        }
        return answer;
    }
}