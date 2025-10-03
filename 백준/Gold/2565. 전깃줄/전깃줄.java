import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 시작점과 끝점
        int[] startPoints = new int[N];
        int[] endPoints = new int[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startPoints[i] = Integer.parseInt(st.nextToken());
            endPoints[i] = Integer.parseInt(st.nextToken());
        }
        
        // start 기준으로 묶기
        int[][] boxes = new int[N][2];
        for (int i = 0; i < N; i++) {
            boxes[i][0] = startPoints[i];
            boxes[i][1] = endPoints[i];
        }
        
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int[] dp = new int[N];
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        // LIS 구하기 (end 값 기준)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j][1] < boxes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // LIS 최대 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }
        System.out.println(N - maxLength); // 전체 개수에서 LIS 길이를 뺀 값 출력
    }
}
