import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList array = new ArrayList();
        array.add(n);
        do{
            if(n%2 == 0){
                n /= 2;
                array.add(n);
            } else {
                n = 3*n+1;
                array.add(n);
            }         
        }while(n != 1);

        int[] answer = new int[array.size()];   
        
        for(int i=0; i<answer.length; i++){
             answer[i] = (int)array.get(i);
        }
        return answer;
    }
}