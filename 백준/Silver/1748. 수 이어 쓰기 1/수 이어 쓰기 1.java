import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long length = 0;
        int len = Integer.toString(num).length();

        if (len == 9) {
            length = ((long) (num - 100000000 + 1) * 9) + 788888889;
        } else if (len == 8) {
            length = ((long) (num - 10000000 + 1) * 8) + 68888889;
        } else if (len == 7) {
            length = ((long) (num - 1000000 + 1) * 7) + 5888889;
        } else if (len == 6) {
            length = ((long) (num - 100000 + 1) * 6) + 488889;
        } else if (len == 5) {
            length = ((long) (num - 10000 + 1) * 5) + 38889;
        } else if (len == 4) {
            length = ((long) (num - 1000 + 1) * 4) + 2889;
        } else if (len == 3) {
            length = ((num - 100 + 1) * 3) + 189;
        } else if (len == 2) {
            length = ((num - 10 + 1) * 2) + 9;
        } else {
            length = num;
        }
        System.out.println(length);
    }
}