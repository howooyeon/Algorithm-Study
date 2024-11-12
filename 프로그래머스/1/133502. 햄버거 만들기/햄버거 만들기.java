class Solution {
    public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            str.append(ingredient[i]);
            
            if(str.length() >= 4){
                String test = str.substring(str.length() - 4);
                if ("1231".equals(test)) {
                    str.delete(str.length() - 4,str.length());
                    answer++;
                }
            }
        }
        return answer;
    }
}