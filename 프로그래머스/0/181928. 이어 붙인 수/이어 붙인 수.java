class Solution {
    public int solution(int[] num_list) {
        String answer = "";
        String answer1 = "";
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                answer += String.valueOf(num_list[i]);
            }else{
                answer1 += String.valueOf(num_list[i]);
            }
        }
        return Integer.parseInt(answer) + Integer.parseInt(answer1);
    }
}