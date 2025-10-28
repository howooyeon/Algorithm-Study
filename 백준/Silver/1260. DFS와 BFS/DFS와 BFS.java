import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점
        M = sc.nextInt(); // 간선
        V = sc.nextInt(); // 시작 노드

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 번호가 작은 노드부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
