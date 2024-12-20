import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] emergencySort = Arrays.copyOfRange(emergency, 0, emergency.length);
        
        Arrays.sort(emergencySort);
        int size = emergency.length;
        
        for(int i = 0; i < emergencySort.length; i++){
            int e = emergencySort[i];
            map.put(e, size-i);
        }
        for(int i = 0; i < emergency.length; i++){
            emergency[i] = map.get(emergency[i]);
        }
        return emergency;
    }
}