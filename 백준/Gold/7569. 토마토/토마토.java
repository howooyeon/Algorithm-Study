import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static Queue<int[]> q = new ArrayDeque<>();

    // 6방향: 동서남북 + 위/아래
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                    if (box[z][x][y] == 1) {
                        q.offer(new int[]{z, x, y});
                    }
                }
            }
        }

        bfs();

        int max = 1;
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (box[z][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, box[z][x][y]);
                }
            }
        }

        System.out.println(max - 1);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;
                if (box[nz][nx][ny] != 0) continue; // 0일 때만 익힐 수 있음

                box[nz][nx][ny] = box[z][x][y] + 1;
                q.offer(new int[]{nz, nx, ny});
            }
        }
    }
}
