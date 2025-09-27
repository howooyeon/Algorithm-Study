import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String s = br.readLine();
        String str = s.toUpperCase();
 
        int[] count = new int[26];
 
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'A';
            count[num]++;
        }
 
        int max = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                answer = (char) (i + 'A');  //아스키코드 문자에서 숫자로
            } else if (max == count[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
