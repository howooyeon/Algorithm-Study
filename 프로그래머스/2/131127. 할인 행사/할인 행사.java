import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int start = 0;
        int end = 9;
        HashMap<String , Integer> map = new HashMap<>();
        
        for( int i = 0; i < want.length ; i++ ){
            map.put(want[i] , number[i]);
        }
        
        for( int i = start; i <= end ; i++ ){
            if( map.containsKey(discount[i])) {
                map.put( discount[i] , map.get(discount[i]) - 1);
            }
        }
        boolean zeroFlag = true;
        
        for( String key : map.keySet()){
            Integer cnt = map.get(key);
            if( cnt != 0 ){
                zeroFlag = false;
            }
        }
        if( zeroFlag ) answer++;
        
        while( end < discount.length - 1 ){
            if(map.containsKey(discount[start])){
                map.put( discount[start] , map.get(discount[start]) + 1);
            }
            start++;
            end++;
            if(map.containsKey(discount[end])){
                map.put(discount[end] , map.get(discount[end]) - 1);
            }
            
            zeroFlag = true;
            for( String key : map.keySet() ){
                Integer cnt = map.get(key);
                if( cnt != 0 ){
                    zeroFlag = false;
                }

            }
            if( zeroFlag) answer++;
        }
        return answer;
    }
}
