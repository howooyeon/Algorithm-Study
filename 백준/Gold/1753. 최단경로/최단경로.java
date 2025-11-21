import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int V, E, start;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        dist[start] = 0;
        for (int i = 0; i < V; i++) {
            int cur = -1;
            int curDist = Integer.MAX_VALUE;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < curDist) {
                    curDist = dist[j];
                    cur = j;
                }
            }

            if (cur == -1) break;
            visited[cur] = true;

            // 인접 노드 탐색
            for (Edge e : graph.get(cur)) {
                if (dist[e.to] > dist[cur] + e.cost) {
                    dist[e.to] = dist[cur] + e.cost;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
