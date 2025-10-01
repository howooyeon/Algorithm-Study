import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> chat = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                chat.clear();
            } else {
                if (!chat.contains(s)) {
                    chat.add(s);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}