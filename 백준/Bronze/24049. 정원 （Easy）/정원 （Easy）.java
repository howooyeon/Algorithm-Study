import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[n + 1][m + 1];
        
        // 왼쪽(col)
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph[i][0] = Integer.parseInt(st.nextToken());
        }
        
        // 위쪽(row)
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= m; j++) {
            graph[0][j] = Integer.parseInt(st.nextToken());
        }
        
        // 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                graph[i][j] = graph[i][j - 1] ^ graph[i - 1][j];
            }
        }
        
        System.out.println(graph[n][m]);
    }
}