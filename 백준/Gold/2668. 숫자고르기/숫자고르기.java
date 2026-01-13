import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 모든 노드에서 DFS
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int x : result) {
            sb.append(x).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) {
            dfs(next);
        }
        // 사이클 발견
        else if (!finished[next]) {
            int temp = next;
            result.add(temp);

            while (temp != cur) {
                temp = arr[temp];
                result.add(temp);
            }
        }

        finished[cur] = true;
    }
}
