class Solution {
    public String solution(String myString, String pat) {
        
        int max = 0; 
        
        for(int i = myString.length(); i>0;i--){
            String sub = myString.substring(0,i);
            if(sub.endsWith(pat)){
                max = i;
                break;
            }
        }        
        
        return myString.substring(0, max);
    }
}