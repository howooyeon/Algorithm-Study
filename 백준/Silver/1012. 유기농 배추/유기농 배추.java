import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;// M: 열, N: 행
    static int[][] field;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 열
                int y = Integer.parseInt(st.nextToken()); // 행
                field[y][x] = 1;
            }

            int worms = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (field[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        worms++;
                    }
                }
            }
            sb.append(worms).append('\n');
        }
        System.out.print(sb.toString());
    }

    static void bfs(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc] || field[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
