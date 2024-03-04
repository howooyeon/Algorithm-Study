import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }
}