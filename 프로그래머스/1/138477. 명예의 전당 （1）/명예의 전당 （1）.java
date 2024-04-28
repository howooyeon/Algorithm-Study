import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < score.length; i++){
            if(pq.size() >= k){
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                }
            }
            else{
                pq.add(score[i]);
            }

            result.add(pq.peek());
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}