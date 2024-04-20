class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int y = 0; ; y++) {
            int x = brown/2 - y + 2;
                if(x * y - brown == yellow){
                    return new int[] {x, y};
                }
            }
        }
}