import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentPeople = 0;
        int maxPeople = 0;

        for (int i = 0; i < 4; i++) {
            int outCount = sc.nextInt();
            int inCount = sc.nextInt();

            currentPeople -= outCount;
            currentPeople += inCount;

            if (currentPeople > maxPeople) {
                maxPeople = currentPeople;
            }
        }

        System.out.println(maxPeople);
        sc.close();
    }
}