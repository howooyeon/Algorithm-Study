import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = n;
        int[] arr = new int[n];

        arr[0] = read();
        for (int i = 1; i < n; i++) if ((arr[i - 1] + (arr[i] = read())) % 2 == 0) k--;

        bw.write(String.valueOf(k));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}