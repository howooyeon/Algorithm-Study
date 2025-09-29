import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for(int i = 0; i < num; i++){

            int n = scanner.nextInt();
            int[] arr = new int[n];

            for(int j = 0; j <n; j++){
                arr[j] = scanner.nextInt();
            }

            Arrays.sort(arr);

            System.out.println((arr[n - 1]- arr[0])*2);
        }
    }
}