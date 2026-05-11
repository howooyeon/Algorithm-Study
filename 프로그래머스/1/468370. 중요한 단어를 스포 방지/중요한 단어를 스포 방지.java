import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
    
        Set<String> notImportant = new HashSet<>();
        int s = 0;
        while (s < message.length()) {
            int t = s; 
            while (t < message.length() && message.charAt(t) != ' ') {
                t++;
            }
            boolean toBeSaved = true;
            if (notImportant.contains(message.substring(s,t))) toBeSaved = false;
            else {
                for (int[] r : spoiler_ranges) { 
                    if (isIn(s,t-1,r[0],r[1])) toBeSaved = false;
                }
            }
            if (toBeSaved) notImportant.add(message.substring(s,t));
            s = t + 1;
        }
        
        int cnt = 0;
        
        for (int[] spoiler : spoiler_ranges) {
            int l = spoiler[0];
            int r = spoiler[1];
            while (l >= 0 && message.charAt(l) != ' ') {
                l--;
            }
            while (r < message.length() && message.charAt(r) != ' ') {
                r++; 
            }
            if (l + 1 > r) continue;
            String[] parts = message.substring(l+1, r).split(" ");
            for (String p : parts) {
                if (notImportant.contains(p)) continue;
                else {
                    notImportant.add(p);
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
    public boolean isIn(int s1, int s2, int r1, int r2) {
        if (s1 <= r2 && s2 >= r1) return true;
        else return false;
    }
}
