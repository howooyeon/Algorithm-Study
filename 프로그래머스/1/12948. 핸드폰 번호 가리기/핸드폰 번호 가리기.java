class Solution {
    public String solution(String ph_number) {
        String answer = "";
        for(int i = 0; i < ph_number.length(); i++){
            if(i < ph_number.length() - 4){
                answer += "*";
            }
            else{
                answer += ph_number.charAt(i);
            }
        }
        return answer;
    }
}