import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        String[] number = {"zero" ,"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < 10; i++){
            numberMap.put(number[i], i);
        }
        
        StringBuilder tmp = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                sb.append(c);
            }else{
                tmp.append(c);
                if(numberMap.containsKey(tmp.toString())){
                    sb.append(numberMap.get(tmp.toString()));
                    tmp = new StringBuilder();
                }
            }
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}