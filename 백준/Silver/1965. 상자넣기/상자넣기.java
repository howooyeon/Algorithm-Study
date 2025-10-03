import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] box = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1); // 최소, 자기 자신 하나

        int maxBoxes = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (box[j] < box[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxBoxes = Math.max(maxBoxes, dp[i]);
        }

        System.out.println(maxBoxes);
    }
}
