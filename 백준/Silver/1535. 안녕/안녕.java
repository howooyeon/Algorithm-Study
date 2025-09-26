import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] L = new int[N+1]; // 체력 소모
        int[] G = new int[N+1]; // 기쁨
        
        for(int i = 1; i <= N; i++) {
            L[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++) {
            G[i] = sc.nextInt();
        }
        
        int[] dp = new int[100]; // 체력은 최대 99까지 소모 가능함
        
        for(int i = 1; i <= N; i++) {
            for(int j = 99; j >= L[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-L[i]] + G[i]);
            }
        }
        System.out.println(dp[99]);
    }
}