class Solution {
    public String solution(String myString) {
        String answer = "";
        answer = myString.toLowerCase();
        if(answer.contains("a")){
            answer = answer.replaceAll("a", "A");
        }
        return answer;
    }
}