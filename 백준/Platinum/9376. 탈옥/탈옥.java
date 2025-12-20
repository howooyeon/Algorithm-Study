import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] map;
    static int[][][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0}; 
    static final int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2]; // 외곽 패딩 추가
            dist = new int[3][h + 2][w + 2]; // 3번 BFS 결과 저장
            List<int[]> prisoners = new ArrayList<>();

            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                    if (map[i][j] == '$') {
                        prisoners.add(new int[]{i, j});
                    }
                }
            }

            // BFS 실행 (외부 + 죄수 2명)
            bfs(0, 0, 0);
            bfs(prisoners.get(0)[0], prisoners.get(0)[1], 1); // 첫 번째 죄수
            bfs(prisoners.get(1)[0], prisoners.get(1)[1], 2); // 두 번째 죄수

            // 최적 탈출 경로 찾기
            int answer = INF;
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    if (map[i][j] == '*') continue; // 벽이면 불가능
                    int totalDoors = dist[0][i][j] + dist[1][i][j] + dist[2][i][j];
                    if (map[i][j] == '#') totalDoors -= 2; // 문 중복 제거
                    answer = Math.min(answer, totalDoors);
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    // BFS 탐색
    static void bfs(int sx, int sy, int idx) {
        for (int i = 0; i < h + 2; i++) {
            Arrays.fill(dist[idx][i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // 우선순위 큐 사용
        pq.add(new int[]{sx, sy, 0});
        dist[idx][sx][sy] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], cost = cur[2];

            if (dist[idx][x][y] < cost) continue; // 이미 더 작은 값이 존재하면 패스

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2) continue;
                if (map[nx][ny] == '*') continue;

                int newCost = cost + (map[nx][ny] == '#' ? 1 : 0); // 문을 열면 비용 증가
                if (dist[idx][nx][ny] > newCost) {
                    dist[idx][nx][ny] = newCost;
                    pq.add(new int[]{nx, ny, newCost});
                }
            }
        }
    }
}