import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sequence = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        // 모든 원소를 돌면서 가장 긴 증가 부분 수열 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 증가 조건 확인
                if (sequence[j] < sequence[i]) {
                    // j번째 원소에 이어붙일 수 있음
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // dp 배열 중 최댓값이 답
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}
