import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int round = 0;
        for (int i = 0; i < enemy.length; i++) {
            int current = enemy[i];
            maxHeap.add(current);
            n -= current;

            // 병사가 부족하면 가장 큰 적 수에 무적권 사용
            if (n < 0) {
                if (k > 0) {
                    n += maxHeap.poll(); // 가장 많은 적 수만큼 병사 수 회복
                    k--;
                } else {
                    break;
                }
            }
            round++;
        }

        return round;
    }
}
