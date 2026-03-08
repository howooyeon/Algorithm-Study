import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] office;
    static List<CCTV> cctvs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // 각 CCTV 종류별 가능한 방향 조합
    static int[][][] dirs = {
            {},
            {{0}, {1}, {2}, {3}},                 // 1번
            {{0, 2}, {1, 3}},                     // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},    // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
            {{0, 1, 2, 3}}                        // 5번
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        dfs(0, office);
        System.out.println(answer);
    }

    static void dfs(int depth, int[][] map) {
        if (depth == cctvs.size()) {
            answer = Math.min(answer, countBlindSpot(map));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        for (int[] dirSet : dirs[type]) {
            int[][] copied = copyMap(map);

            for (int dir : dirSet) {
                watch(cctv.x, cctv.y, dir, copied);
            }

            dfs(depth + 1, copied);
        }
    }

    static void watch(int x, int y, int dir, int[][] map) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (true) {
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
            if (map[nx][ny] == 6) break; // 벽이면 종료

            if (map[nx][ny] == 0) {
                map[nx][ny] = -1; // 감시된 칸 표시
            }

            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }

        return count;
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        return newMap;
    }
}