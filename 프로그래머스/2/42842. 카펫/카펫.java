class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 1;
        while(true){
            int y = brown/2 - x + 2;
                if(x * y - brown == yellow){
                    return new int[] {y, x};
                }
            x++;
        }
    }
}