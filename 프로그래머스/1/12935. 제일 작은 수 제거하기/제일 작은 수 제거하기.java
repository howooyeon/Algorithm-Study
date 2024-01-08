import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;

        if (arr.length <= 1) {
            answer = new int[]{-1};
        } else {
            int[] sortedArr = Arrays.copyOf(arr, arr.length);
            
            Arrays.sort(sortedArr);

            int smallest = sortedArr[0];

            answer = new int[arr.length - 1];
            int index = 0;
            for (int num : arr) {
                if (num != smallest) {
                    answer[index++] = num;
                }
            }
        }

        return answer;
    }
}