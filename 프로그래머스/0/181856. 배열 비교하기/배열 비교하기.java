class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int sum1 = 0;
        int sum2 = 0;
        
        for (int num : arr1) {
            sum1 += num;
        }
        
        for (int num : arr2) {
            sum2 += num;
        }
        
        if (arr1.length < arr2.length) {
            answer = -1;
        } else if (arr1.length > arr2.length) {
            answer = 1;
        } else { 
            if (sum1 > sum2) {
                answer = 1;
            } else if (sum1 < sum2) {
                answer = -1;
            }
        }
        
        return answer;
    }
}