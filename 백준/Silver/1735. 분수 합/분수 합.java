import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		
		int gcd = GCD(b, b1);
		int lcm = b * b1 / gcd;
		
        int numerator = (lcm / b) * a + (lcm / b1) * a1;
        int denominator = lcm;
        
        // 기약분수로 줄여야함
        int g = GCD(Math.abs(numerator), denominator);
        numerator /= g; // 최대공약수로 나눔
        denominator /= g;
        
        System.out.println(numerator);
        System.out.println(denominator);
		
	}

	static int GCD(int a, int b) {
		while(b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
