class Solution {
    public int solution(String myString, String pat) {
        String str = myString.replace('A', 'X').replace('B', 'A').replace('X', 'B');
        if(str.contains(pat)) {
            return 1;
        } else return 0;
    }
}