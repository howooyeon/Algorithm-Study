 import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[] = new int [1001];
        int dp [] = new int [1001];
        
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i - 1; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(dp[i], max);
        }
        
        System.out.println(max);
        
        int max2 = max;
        int arr2[] = new int [1001];
        
        for(int i = n; i >= 1; i--){
            if(dp[i] == max){
                arr2[max] = arr[i];
                max--;
            }
        }
        for(int i = 1; i <= max2; i++){
            System.out.print(arr2[i] + " ");
        }
    }
}