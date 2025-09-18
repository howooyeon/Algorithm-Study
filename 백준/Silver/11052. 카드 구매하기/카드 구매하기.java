import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] p = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			 p[i] = Integer.parseInt(st.nextToken()); // 원본 배열 
		}
		
		int[] dp = new int[N + 1];
        dp[0] = 0;

        for(int n = 1; n <= N; n++) {
            dp[n] = 0;
            for(int i = 1; i <= n; i++) {
                dp[n] = Math.max(dp[n], dp[n - i] + p[i]);
            }
        }
		System.out.println(dp[N]);
	}

}
