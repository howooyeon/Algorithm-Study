import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(num); // 2진수 문자열 변환

            // 문자열은 왼쪽이 상위 비트, 오른쪽이 하위 비트
            int len = binary.length();
            for (int i = 0; i < len; i++) {
                if (binary.charAt(len - 1 - i) == '1') { // 오른쪽부터 확인
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
