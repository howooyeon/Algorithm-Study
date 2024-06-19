class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int length = 0;
        int count = 0;
        
        for(int i = 0; i < intervals.length; i++){
            int[] arrIndex = intervals[i];
            length += arrIndex[1] - arrIndex[0] + 1;
        }
        
        int[] result = new int[length];
        
        for(int i = 0; i < intervals.length; i++){
            for(int j = intervals[i][0]; j < intervals[i][1] + 1; j++){
                result[count] = arr[j];
                count++;
            }
        }
        return result;
    }
}