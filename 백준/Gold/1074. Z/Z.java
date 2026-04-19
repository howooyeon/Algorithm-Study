import java.util.Scanner;

public class Main {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        solve(N, r, c);
        System.out.println(result);
    }

    static void solve(int N, int r, int c) {
        if (N == 0) return;

        int half = 1 << (N - 1); // 2^(N-1)
        int area = half * half;

        // 1사분면
        if (r < half && c < half) {
            solve(N - 1, r, c);
        }
        // 2사분면
        else if (r < half && c >= half) {
            result += area;
            solve(N - 1, r, c - half);
        }
        // 3사분면
        else if (r >= half && c < half) {
            result += 2 * area;
            solve(N - 1, r - half, c);
        }
        // 4사분면
        else {
            result += 3 * area;
            solve(N - 1, r - half, c - half);
        }
    }
}