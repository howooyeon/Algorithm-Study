import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] price = new int[N+1];
        int[] dp = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            price[i] = sc.nextInt();
            dp[i] = Integer.MAX_VALUE; // 최소값 비교를 위해 초기화
        }
        
        dp[0] = 0;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + price[j]);
            }
        }
        
        System.out.println(dp[N]);
    }
}
