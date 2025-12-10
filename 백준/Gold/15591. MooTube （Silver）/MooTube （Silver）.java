import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Query {
        int k, v, idx;
        Query(int k, int v, int idx) {
            this.k = k;
            this.v = v;
            this.idx = idx;
        }
    }

    // Union-Find
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        // union by size
        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        size[a] += size[b];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[N - 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q_ = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(p, q_, r);
        }

        Query[] queries = new Query[Q];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queries[i] = new Query(k, v, i);
        }

        Arrays.sort(edges, (a, b) -> b.w - a.w);
        Arrays.sort(queries, (a, b) -> b.k - a.k);

        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] answer = new int[Q];
        int edgeIdx = 0;

        for (Query q : queries) {
            int k = q.k;
            int v = q.v;

            // 현재 쿼리의 k 이상인 간선들을 모두 union
            while (edgeIdx < edges.length && edges[edgeIdx].w >= k) {
                union(edges[edgeIdx].u, edges[edgeIdx].v);
                edgeIdx++;
            }

            int root = find(v);
            answer[q.idx] = size[root] - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
