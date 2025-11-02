import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, dist, broke;
        Node(int x, int y, int dist, int broke) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broke = broke; // 0 아직 안 부숨 1 이미 부숨
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 도착 지점 도달
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈 칸이고 아직 방문 안했으면
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.broke]) {
                    visited[nx][ny][cur.broke] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1, cur.broke));
                }

                // 벽이고 아직 안 부쉈으면
                if (map[nx][ny] == 1 && cur.broke == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1, 1));
                }
            }
        }

        return -1;
    }
}
