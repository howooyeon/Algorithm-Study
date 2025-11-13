import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			double P = Double.parseDouble(st.nextToken());
            
			int count = 0;
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				double v = Double.parseDouble(st.nextToken());
				double f = Double.parseDouble(st.nextToken());
				double c = Double.parseDouble(st.nextToken());
				
				if((P / v) * c <= f) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}