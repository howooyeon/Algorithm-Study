import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> resultList = new ArrayList<>(); // 결과를 저장할 ArrayList
        
        int prev = -1; // 이전 숫자를 저장할 변수, 초기값은 배열 arr의 범위에 속하지 않는 값으로 설정
        
        for (int num : arr) {
            if (num != prev) { // 현재 숫자가 이전 숫자와 다를 때만 결과에 추가
                resultList.add(num);
                prev = num; // 현재 숫자를 이전 숫자로 업데이트
            }
        }
        
        // ArrayList를 배열로 변환하여 반환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예시 배열 arr에 대한 테스트
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        int[] result1 = solution.solution(arr1);
        int[] result2 = solution.solution(arr2);

        System.out.println(Arrays.toString(result1)); // [1, 3, 0, 1]
        System.out.println(Arrays.toString(result2)); // [4, 3]
    }
}
