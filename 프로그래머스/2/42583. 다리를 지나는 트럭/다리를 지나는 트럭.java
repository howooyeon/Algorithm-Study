import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	Queue q = new LinkedList();
    
        for(int i = 0; i < bridge_length - 1; i++){
            q.add(0);
        }
        
        int current_w = truck_weights[0];
        q.add(current_w);
        
        int answer = 1; // 0번째 트럭이 이미 올라갔으므로 시간 1부터 시작
        int index = 1; // 0번째 트럭이 이미 올라갔으므로 다음 트럭 index는 1부터 시작
        
        while(!q.isEmpty()){
            answer++; // 시간 1 증가
            
            int removed = (int) q.poll(); // 빠져나갈 트럭 1대 제거
            current_w -= removed; // 현재 다리의 트럭무게에서 제거된 트럭 무게 제거

            if(index < truck_weights.length){
            	
                if(current_w + truck_weights[index] <= weight){
                    current_w += truck_weights[index]; // 다음 트럭 무게 추가
                    q.add(truck_weights[index]); // queue 에 다음 트럭 추가
                    index++; // index 증가
                } else{
                    q.add(0); 
                }
            }
        }
        return answer;
    }
}