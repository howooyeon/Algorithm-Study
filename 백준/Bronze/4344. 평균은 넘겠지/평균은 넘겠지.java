import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            String[] input = br.readLine().split(" ");
            
            // 첫 번째 값은 학생 수(N)
            int N = Integer.parseInt(input[0]);
            double sum = 0;
            
            // 점수들을 합산
            for (int j = 1; j <= N; j++) {
                sum += Integer.parseInt(input[j]);
            }
            
            // 평균을 계산
            double average = sum / N;
            
            int count = 0;
            // 평균을 넘는 학생 수를 셈
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(input[j]) > average) {
                    count++;
                }
            }
            
            // 최종 비율을 계산하고 출력
            double result = (double) count / N * 100;
            System.out.printf("%.3f%%\n", result);
        }
        
        br.close();
    }
}