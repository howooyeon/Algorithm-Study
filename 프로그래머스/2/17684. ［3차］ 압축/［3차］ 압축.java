import java.util.*;

public class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i - 1)), i);
        }

        List<Integer> result = new ArrayList<>();
        int nextIndex = 27; // 다음에 추가될 사전 번호
        int i = 0;

        while (i < msg.length()) {
            String w = "";
            int j = i + 1;
            
            while (j <= msg.length()) {
                String temp = msg.substring(i, j);
                if (dictionary.containsKey(temp)) {
                    w = temp;
                    j++;
                } else {
                    dictionary.put(temp, nextIndex++);
                    break;
                }
            }

            result.add(dictionary.get(w));
            i += w.length();
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}