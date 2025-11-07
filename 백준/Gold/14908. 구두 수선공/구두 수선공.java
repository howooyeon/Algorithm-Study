import java.io.*;
import java.util.*;

public class Main {
    static class Work {
        int idx;
        int t;
        int s;

        Work(int idx, int t, int s) {
            this.idx = idx;
            this.t = t;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Work> pq = new PriorityQueue<>((a, b) -> {
            long left = (long) a.t * b.s;
            long right = (long) b.t * a.s;
            if (left == right) return a.idx - b.idx;
            return Long.compare(left, right);
        });

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            pq.add(new Work(i, t, s));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().idx).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
