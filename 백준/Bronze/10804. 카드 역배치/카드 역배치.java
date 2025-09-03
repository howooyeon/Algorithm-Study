import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[21];
		
		Scanner sc = new Scanner(System.in);
		
		for(int n = 1; n <= 20; n++) {
			arr[n] = n;
		}
		
		for(int i = 0; i < 10; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			while(a < b) {
				int tmp = arr[a];
				arr[a] = arr[b];
				arr[b] = tmp;
				
				a++;
				b--;
			}
		}
        
        for(int n = 1; n <= 20; n++) {
				System.out.print(arr[n] + " ");
		}
	}
}
