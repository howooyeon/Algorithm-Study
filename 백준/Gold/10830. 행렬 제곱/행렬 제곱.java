import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long B;
    static int[][] origin;
    static final int MOD = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = power(origin, B);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int v : row) sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 행렬 거듭제곱
    static int[][] power(int[][] A, long exp) {
        if (exp == 1) return copy(A);

        int[][] half = power(A, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1) result = multiply(result, A);

        return result;
    }

    // 행렬 곱셈
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] R = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += A[i][k] * B[k][j];
                }
                R[i][j] = sum % MOD;
            }
        }
        return R;
    }

    // 깊은 복사
    static int[][] copy(int[][] A) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(A[i], 0, temp[i], 0, N);
        }
        return temp;
    }
}
