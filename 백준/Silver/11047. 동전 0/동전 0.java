import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            int coinValue = coins[i];

            while (K >= coinValue) {
                K -= coinValue;
                count++;
            }
        }

        System.out.println(count);
    }
}
