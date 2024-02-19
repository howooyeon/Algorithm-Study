import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> resultList = new ArrayList<>();
        
        int prev = -1; 
        
        for (int num : arr) {
            if (num != prev) {
                resultList.add(num);
                prev = num;
            }
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
