import java.util.*;

public class Main {
    static int[] parent; // 각 노드의 부모를 저장하는 배열

    static int find(int x) {
        if (parent[x] == x) return x; // 자기 자신이 부모면 반환
        return parent[x] = find(parent[x]); // 재귀로 부모 찾아가면서 갱신
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;

        parent[parentB] = parentA;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집
        int M = sc.nextInt(); // 길

        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(); // 집 a
            int b = sc.nextInt(); // 집 b
            int cost = sc.nextInt(); // 연결 비용
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = cost;
        }

        Arrays.sort(edges, (x, y) -> x[2] - y[2]);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalCost = 0; // 전체 연결 비용
        int lastCost = 0;  // 마지막 간선 비용 저장용

        for (int i = 0; i < M; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];

            if (union(a, b)) {
                totalCost += cost;
                lastCost = cost;
            }
        }

        System.out.println(totalCost - lastCost);
    }
}
