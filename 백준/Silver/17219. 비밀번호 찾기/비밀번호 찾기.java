import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputSize = reader.readLine().split(" ");
        
        int N = Integer.parseInt(inputSize[0]);
        int M = Integer.parseInt(inputSize[1]);
        Map<String, String> saveSite = new HashMap();
        
        for (int count = 0; count < N; count++) {
            String[] input = reader.readLine().split(" ");
            saveSite.put(input[0], input[1]);
        }
        
        String[] searchSite = new String[M];
        for (int index = 0; index < M; index++) {
            String input = reader.readLine();
            searchSite[index] = input;
        }
 
        for (int index = 0; index < M; index++) {
            System.out.println(saveSite.get(searchSite[index]));
        }
    }
}