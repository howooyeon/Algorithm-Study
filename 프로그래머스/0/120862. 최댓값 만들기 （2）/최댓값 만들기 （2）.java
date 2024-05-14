import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int answer1 = numbers[0] * numbers[1];
        int answer2 = numbers[numbers.length - 2] * numbers[numbers.length - 1];
        return answer1 < answer2 ? answer2 : answer1;
    }
}