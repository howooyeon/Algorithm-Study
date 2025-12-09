import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (command == 'D') {
                    if (map.isEmpty()) continue;

                    if (value == 1) {  
                        // 최댓값 삭제
                        int maxKey = map.lastKey();
                        int cnt = map.get(maxKey);
                        if (cnt == 1) map.remove(maxKey);
                        else map.put(maxKey, cnt - 1);
                    } else {            
                        // 최솟값 삭제
                        int minKey = map.firstKey();
                        int cnt = map.get(minKey);
                        if (cnt == 1) map.remove(minKey);
                        else map.put(minKey, cnt - 1);
                    }
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
