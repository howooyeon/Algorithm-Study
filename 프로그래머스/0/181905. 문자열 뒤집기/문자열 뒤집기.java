class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder();
        StringBuilder str = new StringBuilder(my_string);
        

        answer.append(str.substring(0, s)) 
              .append((new StringBuilder(str.substring(s, e + 1)).reverse()))
              .append(str.substring(e + 1));
              
        return answer.toString();
    }
}