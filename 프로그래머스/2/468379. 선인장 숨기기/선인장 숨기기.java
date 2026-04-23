import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int[][] time = new int[m][n];

        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            time[r][c] = i + 1;
        }

        int INF = 1_000_000_000;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (time[i][j] == 0) time[i][j] = INF;
            }
        }

        int[][] rowMin = new int[m][n - w + 1];

        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {

                while (!dq.isEmpty() && time[i][dq.peekLast()] >= time[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(j);

                if (dq.peekFirst() <= j - w) dq.pollFirst();

                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = time[i][dq.peekFirst()];
                }
            }
        }

        int maxVal = -1;
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int j = 0; j <= n - w; j++) {

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {

                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(i);

                if (dq.peekFirst() <= i - h) dq.pollFirst();

                if (i >= h - 1) {
                    int val = rowMin[dq.peekFirst()][j];

                    int r = i - h + 1;
                    int c = j;

                    if (val == INF) val = Integer.MAX_VALUE;

                    if (val > maxVal) {
                        maxVal = val;
                        answer[0] = r;
                        answer[1] = c;
                    } else if (val == maxVal) {
                        if (r < answer[0] || (r == answer[0] && c < answer[1])) {
                            answer[0] = r;
                            answer[1] = c;
                        }
                    }
                }
            }
        }

        return answer;
    }
}