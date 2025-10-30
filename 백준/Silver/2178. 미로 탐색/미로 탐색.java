import java.util.*;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 제거

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        visited[x][y] = true;

        // 시작점도 1칸 포함
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 벗어나면 skip
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                // 벽이거나 방문했으면 skip
                if (maze[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                maze[nx][ny] = maze[cx][cy] + 1;
                q.add(new int[] { nx, ny });
            }
        }

        return maze[N - 1][M - 1];
    }
}
