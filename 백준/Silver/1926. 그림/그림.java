import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int [][] ad;
    static boolean [][] visit;
    static int draw_size;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        int component = 0;
        int draw_max_size = 0;
        ad = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];
 
        for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                ad[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                draw_size = 0;
                if(!visit[i][j] && ad[i][j] == 1) {
                    draw_size = dfs(i,j);
                    if (draw_max_size < draw_size)
                        draw_max_size = draw_size;
                    component++;
                }
            }
        }
        System.out.println(component);
        System.out.println(draw_max_size);
    }
 
    static int dfs(int x,int y){
        visit[x][y] = true;
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
 
        for(int i = 0; i < 4; i++){
            int row = x + dx[i];
            int col = y + dy[i];
 
            if(isRangeTrue(row,col) && !visit[row][col] && ad[row][col] == 1) {
                dfs(row, col);
                draw_size++;
            }
        }
        return draw_size + 1;
    }
 
    static boolean isRangeTrue(int x, int y){
        return x > 0 && x <= n && y > 0 && y <= m;
    }
}
 
