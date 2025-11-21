import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[N - 1][M - 1]);
    }

    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                int cost = dist[x][y] + map[nx][ny]; // 벽이면 +1, 빈방이면 +0

                if (dist[nx][ny] > cost) {
                    dist[nx][ny] = cost;
                    if (map[nx][ny] == 0) dq.addFirst(new int[]{nx, ny});
                    else dq.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}
