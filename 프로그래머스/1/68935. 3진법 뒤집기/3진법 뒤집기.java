import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> revTNList = new ArrayList<Integer>(); 
        
        while(n!= 0){
            revTNList.add(n%3);
            n /= 3;
        }
        for(int i=0; i < revTNList.size(); i++)
            answer += revTNList.get(revTNList.size() - 1 - i) * Math.pow(3, i);
        
        
        return answer;
        
    }
}