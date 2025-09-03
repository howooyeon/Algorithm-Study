import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }

        StringBuilder result = new StringBuilder();

        for (int j = 0; j < files[0].length(); j++) {
            char c = files[0].charAt(j);
            boolean same = true;

            for (int i = 1; i < n; i++) {
                if (files[i].charAt(j) != c) {
                    same = false;
                    break;
                }
            }

            if (same) {
                result.append(c);
            } else {
                result.append('?');
            }
        }

        System.out.println(result);
    }
}
