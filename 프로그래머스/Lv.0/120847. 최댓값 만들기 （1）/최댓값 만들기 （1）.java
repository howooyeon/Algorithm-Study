import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            Arrays.sort(numbers);
            answer[i] = numbers[i];
        }
        int lastIndex = answer.length - 1;
        return answer[lastIndex] * answer[lastIndex - 1];
    }
}