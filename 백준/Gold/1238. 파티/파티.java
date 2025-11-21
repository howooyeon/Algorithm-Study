import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, cost;
        Node(int to, int cost) { this.to = to; this.cost = cost; }
        public int compareTo(Node o) { return this.cost - o.cost; }
    }

    static int N, M, X;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        int maxTime = 0;

        // 학생 1 ~ N까지 X로 가는 최단거리 계산
        for (int i = 1; i <= N; i++) {
            int toX = dijkstra(i, X); // i -> X
            int fromX = dijkstra(X, i); // X -> i
            maxTime = Math.max(maxTime, toX + fromX);
        }

        System.out.println(maxTime);
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.to]) continue;

            for (Node next : graph[cur.to]) {
                int cost = cur.cost + next.cost;
                if (dist[next.to] > cost) {
                    dist[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }
        return dist[end];
    }
}
