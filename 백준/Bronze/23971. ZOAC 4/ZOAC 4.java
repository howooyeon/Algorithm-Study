import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer str = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(str.nextToken()); 	// 테이블 행 H
        int column = Integer.parseInt(str.nextToken()); // 테이블 열 W
        int rowGap = Integer.parseInt(str.nextToken()); // 참가자 세로 공백 N
        int columnGap = Integer.parseInt(str.nextToken()); // 참가자 가로 공백 M
        
        // 최대 참가자 수 구하는 공식
        int result = ((row-1)/(rowGap+1)+1) * ((column-1)/(columnGap+1)+1);
        
        System.out.println(result);
    }
}