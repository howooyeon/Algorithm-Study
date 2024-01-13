class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        if(n % slice == 0){
            answer = (int)Math.round(n/slice);
        }else{
            answer = (int)Math.round(n/slice) + 1;
        }
       
        return answer;
    }
}