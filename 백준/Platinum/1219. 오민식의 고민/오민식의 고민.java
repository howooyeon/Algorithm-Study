import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long INF = Long.MIN_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int S = Integer.parseInt(st.nextToken()); // 시작 도시
        int E = Integer.parseInt(st.nextToken()); // 도착 도시
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long[] earn = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earn[i] = Long.parseLong(st.nextToken());
        }

        long[] dist = new long[N];
        Arrays.fill(dist, INF);
        dist[S] = earn[S];

        for (int i = 0; i < N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;
                long nextMoney = dist[e.from] - e.cost + earn[e.to];
                if (dist[e.to] < nextMoney) {
                    dist[e.to] = nextMoney;
                }
            }
        }

        boolean[] infinite = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (Edge e : edges) {
                if (dist[e.from] == INF) continue;
                long nextMoney = dist[e.from] - e.cost + earn[e.to];

                // 도착 가능한 양의 사이클 발견
                if (dist[e.to] < nextMoney) {
                    dist[e.to] = nextMoney;
                    infinite[e.to] = true;
                }
                // 양의 사이클 전파
                if (infinite[e.from]) infinite[e.to] = true;
            }
        }

        if (dist[E] == INF) {
            System.out.println("gg"); 
        } else if (infinite[E]) {
            System.out.println("Gee");
        } else {
            System.out.println(dist[E]);
        }
    }
}
