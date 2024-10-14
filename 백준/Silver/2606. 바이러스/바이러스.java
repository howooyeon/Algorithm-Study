import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int count = 0;
	static int[][] graph = new int[101][101];
	//간선의 최대 개수를 알 수 가 없기에 적당히 큰 값을 저장함.
	static boolean[] visit = new boolean[100000000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}
		DFS(1);
		System.out.println(count);
	}
	
	public static void DFS(int node) {
		visit[node] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i] && graph[node][i] == 1) {
				count++;
				DFS(i);
			}
		}
	}

}