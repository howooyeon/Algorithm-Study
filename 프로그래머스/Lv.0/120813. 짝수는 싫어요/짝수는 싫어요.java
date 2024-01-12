class Solution {
    public int[] solution(int n) {
        int[] answer = (n % 2 == 0) ? new int[n / 2] : new int[n / 2 + 1];
        int index = 0;
        for (int i = 1; i<= n; i+= 2) {
            answer[index++] = i;
        }
        return answer;
    }
}