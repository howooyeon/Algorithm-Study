import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 관계 수

        // 인접 리스트
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        // BFS
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{A, 0});
        visited[A] = true;

        int answer = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int person = cur[0];
            int cnt = cur[1];

            if (person == B) {
                answer = cnt;
                break;
            }

            for (int next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }

        System.out.println(answer);
    }
}
