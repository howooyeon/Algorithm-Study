import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, via);   // 1단계
        sb.append(from).append(" ").append(to).append("\n"); // 2단계
        hanoi(n - 1, via, from, to);   // 3단계
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 이동 횟수 출력
        int count = (1 << n) - 1;
        System.out.println(count);

        // 이동 과정 출력
        hanoi(n, 1, 2, 3);

        System.out.print(sb);
    }
}