import java.io.*;
import java.util.*;

public class Main {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
      int N = Integer.parseInt(br.readLine());
      int M = 0;
      double result = 0;
      
      int[] score = new int[N];
      StringTokenizer st = new StringTokenizer( br.readLine() );
      
      for( int i = 0; i < N; i++) {
    	  int num = Integer.parseInt(st.nextToken());
    	  score[i] = num;
    	  if (M < num) {
    		  M = num;
    	  }
      }
      
      for(int i = 0; i < N;i++) {
    	  if( score[i] <= M) {
    		  result += (double)score[i] / M * 100;
    	  }
      }
       
      bw.write(result/N + "\n");
      
      bw.flush();
      bw.close();
      br.close();
   }   
}