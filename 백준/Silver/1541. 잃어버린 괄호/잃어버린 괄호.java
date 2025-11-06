import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();

        String[] minusSplit = expr.split("-");

        int result = 0;
        
        for (int i = 0; i < minusSplit.length; i++) {
            int partSum = 0;

            String[] plusSplit = minusSplit[i].split("\\+");
            for (String num : plusSplit) {
                partSum += Integer.parseInt(num);
            }

            if (i == 0) result += partSum;
            else result -= partSum;
        }

        System.out.println(result);
    }
}
