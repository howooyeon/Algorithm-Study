class Solution {
    public int solution(int num) {
        int count = 0;
        
        if(num == 1) return 0;
        
        // 계산 중 정수 오버플로우를 방지하기 위해 tempNum을 long으로 사용
        long tempNum = num;
        
        while(tempNum != 1){
            if(tempNum % 2 == 0) {
                tempNum /= 2;
            } else {
                tempNum = (tempNum * 3) + 1;
            }
            count++;
            
            if(tempNum == 1){
                return count;
            }
            if(count >= 500) return -1;
        }
        return count;
    }
}
