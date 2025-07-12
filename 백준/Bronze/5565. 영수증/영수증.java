import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        sum = sc.nextInt();

        for(int i = 0; i < 9; i++) {
            int bookPrice = sc.nextInt();
            sum -= bookPrice;
        }
        
        System.out.println(sum);
        sc.close();
    }

}