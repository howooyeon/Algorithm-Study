import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] arr = new String[n][4];

        for(int i = 0; i < n; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = scanner.next();
            arr[i][2] = scanner.next();
            arr[i][3] = scanner.next();
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].equals(o2[1])) { //국어
                    if(o1[2].equals(o2[2])) { //영어
                        if(o1[3].equals(o2[3])) { //수학
                            return o1[0].compareTo(o2[0]); // 이름 오름차순 정렬
                        } else {
                            return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]); //수학 내림차순
                        }
                    } else {
                        return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); //영어 오름차순
                    }
                } else {
                    return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]); //국어 내림차순
                }
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i][0]);
        }
    }
}