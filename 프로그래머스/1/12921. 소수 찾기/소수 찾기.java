class Solution {
    public int solution(int n) {
	    int answer = 1;

	for (int i = 3; i <= n; i++) {
		    int cnt = 0;
             for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt++;
					break;
				}
			}
			if(cnt == 0) {
				answer++;
			}
		}
		return answer;
    }
}