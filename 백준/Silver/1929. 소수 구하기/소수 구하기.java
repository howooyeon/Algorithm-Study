import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        primeNumberSieve(M, N);
    }

    static void primeNumberSieve(int M, int N) {
        boolean[] isNotPrime = new boolean[N + 1];

        isNotPrime[0] = true; // 0은 소수 아님
        isNotPrime[1] = true; // 1은 소수 아님

        // 2부터 √N까지 확인
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) { // i가 소수라면
                // i의 배수들을 전부 소수가 아니라고 표시
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
