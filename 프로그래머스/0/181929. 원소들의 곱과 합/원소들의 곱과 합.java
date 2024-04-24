class Solution {
    public int solution(int[] num_list) {
        int product = 1; 
        int sum = 0;
        for(int i = 0; i < num_list.length; i++){
            product *= num_list[i];
            sum += num_list[i];
        }
        
        int squareSum = sum * sum;
        
        if(product < squareSum){
            return 1;
        } else {
            return 0;
        }
    }
}
