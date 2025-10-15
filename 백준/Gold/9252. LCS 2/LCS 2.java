import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String ss = br.readLine();

        int len = s.length();
        int len2 = ss.length();
        int[][] dp = new int[len + 1][len2 + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == ss.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[len][len2]);

        // 공통 부분수열 역추적
        StringBuilder sb = new StringBuilder();
        int i = len;
        int j = len2;

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == ss.charAt(j - 1)) {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // 역순이라 뒤집어서 출력
        System.out.println(sb.reverse().toString());
    }
}
