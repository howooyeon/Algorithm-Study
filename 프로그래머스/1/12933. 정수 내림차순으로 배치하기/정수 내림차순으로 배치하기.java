import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = "";
        String str_arr[] = Long.toString(n).split("");
        Arrays.sort(str_arr,Collections.reverseOrder());
        
        for(int i=0;i<str_arr.length;i++){
            str+=str_arr[i];
        }
        
        answer = Long.parseLong(str);
        return answer;
    }
}