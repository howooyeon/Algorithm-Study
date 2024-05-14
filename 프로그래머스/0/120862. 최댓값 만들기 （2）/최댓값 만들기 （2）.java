import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int answer1 = numbers[0] * numbers[1];
        int answer2 = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        if(answer1 < answer2) {
            return answer2;
        }else{
            return answer1;
        }
    }
}