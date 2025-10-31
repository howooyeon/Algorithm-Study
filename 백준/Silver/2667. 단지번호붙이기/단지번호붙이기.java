import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 }; // 상하 좌우
    static int[] dy = { 0, 0, -1, 1 };
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complexList = new ArrayList<>();

        // 모든 좌표를 돌면서 단지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    complexList.add(count);
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(complexList);

        System.out.println(complexList.size()); // 단지 수
        for (int c : complexList) {
            System.out.println(c);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 밖이거나 0이거나 이미 방문했으면 스킵
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 0 || visited[nx][ny]) continue;

            dfs(nx, ny);
        }
    }
}
