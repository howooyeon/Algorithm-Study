import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            hashSet.add(n); // 중복을 제거한다.
        }

        if (max >= hashSet.size()) {
            return hashSet.size();
        } else {
            return max;
        }
    }
}