class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    int moveX = -1;
    int moveY = -1;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] arr = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                arr[i][j] = park[i].charAt(j);
                
                if(arr[i][j] == 'S'){
                    moveX = i;
                    moveY = j;
                }
            }
        }
        
        for(String route : routes){
            String direction = route.split(" ")[0];
            int num = Integer.parseInt(route.split(" ")[1]);
            int dir = -1;
            
            if(direction.equals("E")) dir = 0;
            else if(direction.equals("W")) dir = 1;
            else if(direction.equals("S")) dir = 2;
            else if(direction.equals("N")) dir = 3;
            
            move(arr, dir, num);
        }
        
        answer[0] = moveX;
        answer[1] = moveY;
        
        return answer;
    }
    
    public void move(char[][] park, int dir, int num){
        int nx = moveX, ny = moveY;
        boolean isPossible = true;
        
        for(int i = 0; i < num; i++){
            nx += dx[dir];
            ny += dy[dir];
            
            if(nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length){
                isPossible = false;
                break;
            }
            else{
                if(park[nx][ny] == 'X'){
                    isPossible = false;
                    break;
                }
            }
        }
        
        if(isPossible){
            moveX += dx[dir] * num;
            moveY += dy[dir] * num;
        }
    }
    
}