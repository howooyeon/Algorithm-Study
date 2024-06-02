import java.util.*;

class Solution {
    public int[] solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) { // 약수 중 큰 수 저장
                    arr.add(n / i);
                }
            }
        }
        Collections.sort(arr);

        int[] result = new int[arr.size()];
        int index = 0;
        for (int num : arr) {
            result[index++] = num;
        }
        
        return result;
    }
}
