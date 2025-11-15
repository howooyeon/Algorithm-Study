import java.io.*;
import java.util.*;

class Edge {
    int a, b, w;

    Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

public class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false; // 이미 같은 집합

        parent[b] = a; // 합치기
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        // 비용 기준 오름차순 정렬
        Arrays.sort(edges, (e1, e2) -> e1.w - e2.w);

        int result = 0;

        // 크루스칼 실행
        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                result += e.w; // 간선 포함
            }
        }

        System.out.println(result);
    }
}
