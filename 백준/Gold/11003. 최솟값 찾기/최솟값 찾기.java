import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int idx, value;
        Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekFirst().idx <= i - L) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast().value > now) {
                deque.pollLast();
            }

            deque.offerLast(new Node(i, now));

            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.print(sb.toString());
    }
}
