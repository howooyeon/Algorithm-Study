import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int tree[][];
	
	// 전위 순회
	static void preorder_traverse(int node) {
		if (node == -19) return; 
		System.out.print((char)(node + 65));
		preorder_traverse(tree[node][0]); // 왼쪽 자식 순회
		preorder_traverse(tree[node][1]); // 오른쪽 자식 순회
	}
	
	// 중위 순회
	static void inorder_traverse(int node) {
		if (node == -19) return; 
		inorder_traverse(tree[node][0]); 
		System.out.print((char)(node + 65));
		inorder_traverse(tree[node][1]);
	}
	
	// 후위 순회
	static void postorder_traverse(int node) {
		if (node == -19) return;
		postorder_traverse(tree[node][0]);
		postorder_traverse(tree[node][1]);
		System.out.print((char)(node + 65));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		tree = new int [26][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			int idx = (int)st.nextToken().charAt(0) - 65;
			tree[idx][0] = (int)st.nextToken().charAt(0) - 65;
			tree[idx][1] = (int)st.nextToken().charAt(0) - 65;
		}
		
		preorder_traverse(0); // 전위순회
		System.out.println();
		inorder_traverse(0); // 중위순회
		System.out.println();
		postorder_traverse(0); // 후위순회
	}
}