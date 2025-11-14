import java.io.*;
import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u; this.v = v; this.w = w;
    }
}

public class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == -1) return -1;
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        // 둘 중 하나라도 발전소(-1)면 전체가 발전소 그룹으로 연결
        if (a == -1) {
            parent[b] = -1;
        } else if (b == -1) {
            parent[a] = -1;
        } else {
            // 일반적인 union
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 발전소 있는 도시 처리
        st = new StringTokenizer(br.readLine());
        int powered = K;  // 발전소 포함된 도시 수
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(st.nextToken());
            parent[city] = -1;  // 발전소 그룹
        }

        // 간선 입력
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }

        // 비용 기준 정렬
        Arrays.sort(edges, (a, b) -> a.w - b.w);

        int total = 0;  // 총 비용

        for (Edge e : edges) {
            int a = find(e.u);
            int b = find(e.v);

            if (a != b) {
                union(e.u, e.v);
                total += e.w;

                // union으로 인해 -1 그룹에 새 도시 포함되면 카운트 증가
                if (find(e.u) == -1 && a != -1) powered++;
                if (find(e.v) == -1 && b != -1) powered++;

                // 모든 도시가 전기 공급 받으면 종료
                if (powered == N) break;
            }
        }

        System.out.println(total);
    }
}
