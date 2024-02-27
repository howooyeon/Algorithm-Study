class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length(); 
        System.out.println(length);
        answer = length % 2 == 0 ? s.substring(length / 2 - 1, length / 2 + 1) : s.substring(length / 2, length / 2 + 1);
        return answer;
    }
}
