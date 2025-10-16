import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int n = A.length();
        int m = B.length();
        int k = C.length();

        int[][][] dp = new int[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            char ca = A.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = B.charAt(j - 1);
                for (int t = 1; t <= k; t++) {
                    char cc = C.charAt(t - 1);
                    if (ca == cb && ca == cc) {
                        dp[i][j][t] = dp[i - 1][j - 1][t - 1] + 1;
                    } else {
                        dp[i][j][t] = Math.max(
                            Math.max(dp[i - 1][j][t], dp[i][j - 1][t]),
                            Math.max(dp[i][j][t - 1], Math.max(dp[i - 1][j - 1][t], Math.max(dp[i - 1][j][t - 1], dp[i][j - 1][t - 1])))
                        );
                    }
                }
            }
        }

        System.out.println(dp[n][m][k]);
    }
}
