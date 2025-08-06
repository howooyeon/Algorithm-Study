import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    static int N;
    static int[] permutation;
    static boolean[] check;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        permutation = new int[N + 1];
        check = new boolean[N + 1];
 
        getPermutation(1);
    }
 
    private static void getPermutation(int depth) {
        if (depth == N + 1) {
            getPrintAnswer();
            return;
        }
 
        for (int index = 1; index <= N; index++) {
            if (!check[index]) {
                check[index] = true;
                permutation[depth] = index;
                getPermutation(depth + 1);
                check[index] = false;
            }
        }
    }
 
    private static void getPrintAnswer() {
        for (int index = 1; index <= N; index++) {
            System.out.print(permutation[index] + " ");
        }
        System.out.println();
    }
}