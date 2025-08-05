import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int number = A * B * C;
        
        int[] counts = new int[10];
        while (number > 0) {
            counts[number % 10]++;
            number /= 10;
        }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
    }
}