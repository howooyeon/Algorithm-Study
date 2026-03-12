import java.io.*;
import java.util.*;

public class Main {

    static class Tank {
        int id;
        int r, c;

        Tank(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static Tank[] tanks;
    static StringBuilder sb = new StringBuilder();
    static int moveCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tanks = new Tank[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tanks[i] = new Tank(i + 1, r, c);
        }

        adjustRows();
        adjustCols();

        System.out.println(moveCount);
        System.out.print(sb);
    }

    static void adjustRows() {
        Tank[] arr = tanks.clone();
        Arrays.sort(arr, Comparator.comparingInt(a -> a.r));

        for (int i = 0; i < N; i++) {
            Tank cur = arr[i];
            int targetRow = i + 1;

            while (cur.r > targetRow) {
                cur.r--;
                moveCount++;
                sb.append(cur.id).append(" U\n");
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            Tank cur = arr[i];
            int targetRow = i + 1;

            while (cur.r < targetRow) {
                cur.r++;
                moveCount++;
                sb.append(cur.id).append(" D\n");
            }
        }
    }

    static void adjustCols() {
        Tank[] arr = tanks.clone();
        Arrays.sort(arr, Comparator.comparingInt(a -> a.c));

        for (int i = 0; i < N; i++) {
            Tank cur = arr[i];
            int targetCol = i + 1;

            while (cur.c > targetCol) {
                cur.c--;
                moveCount++;
                sb.append(cur.id).append(" L\n");
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            Tank cur = arr[i];
            int targetCol = i + 1;

            while (cur.c < targetCol) {
                cur.c++;
                moveCount++;
                sb.append(cur.id).append(" R\n");
            }
        }
    }
}