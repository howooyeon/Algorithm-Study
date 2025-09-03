import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][]arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int k = sc.nextInt();
		
		for(int p = 0; p < k; p++) {
			int sum = 0;
			
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r = i - 1; r < x; r++) {
				for(int c = j - 1; c < y; c++) {
					sum += arr[r][c];
				}
			}
			System.out.println(sum);
		}
	}
}
