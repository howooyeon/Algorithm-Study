import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String ss = br.readLine();

        int len = s.length();
        int len2 = ss.length();
        int dp[][] = new int[len + 1][len2 + 1];

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
    }
}
