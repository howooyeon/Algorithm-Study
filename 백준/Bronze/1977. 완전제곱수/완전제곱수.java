import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int sum = 0;
        int min = -1;

        for (int i = M; i <= N; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (sqrt * sqrt == i) {
                sum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (sum == 0) { // 완전제곱수 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
