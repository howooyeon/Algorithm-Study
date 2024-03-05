class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;

        String str = s.toUpperCase();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'P'){ 
                pCount++;
            }
            if(str.charAt(i) == 'Y'){ 
                yCount++;
            }
        }
        return pCount == yCount;
    }
}
