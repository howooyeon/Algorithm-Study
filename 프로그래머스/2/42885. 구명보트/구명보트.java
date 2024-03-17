import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
            
        Arrays.sort(people);
        int i = people.length - 1;
        int front = 0;
        while (i >= front) {
            if (people[i] + people[front] <= limit)
                front++; 
            answer++; 
            i--;
        }
        return answer;
    }
}