import java.io.*;

public class Main {

	static final int LIMIT = 1000000;
	static boolean[] isNotPrime = new boolean[LIMIT + 1];
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	
	    // 에라토스테네스의 체
	        isNotPrime[0] = isNotPrime[1] = true;
	        for (int i = 2; i * i <= LIMIT; i++) {
	            if (!isNotPrime[i]) {
	                for (int j = i * i; j <= LIMIT; j += i) {
	                    isNotPrime[j] = true;
	                }
	            }
	        }
	
	        while (true) {
	            int n = Integer.parseInt(br.readLine());
	            if (n == 0) break;
	
	            boolean found = false;
	            for (int a = 3; a <= n / 2; a += 2) { // 홀수 소수만 확인
	                if (!isNotPrime[a] && !isNotPrime[n - a]) {
	                    sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append("\n");
	                    found = true;
	                    break;
	                }
	            }
	            if (!found) sb.append("Goldbach's conjecture is wrong.\n");
	        }
	
        System.out.print(sb);
    }
}

