import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }
        
        for (int num : delete_list) {
            arrList.remove(Integer.valueOf(num));
        }
        
        answerList = new ArrayList<>(arrList);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
