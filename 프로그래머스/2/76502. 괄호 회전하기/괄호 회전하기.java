import java.util.Stack;

public class Solution {
    
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') { // 열린 괄호일 경우 스택에 추가
                stack.push(c);
            } else { // 닫힌 괄호일 경우
                if (stack.isEmpty()) return false; // 스택이 비어 있으면 유효하지 않음
                char top = stack.pop();
                // 짝이 맞지 않으면 유효하지 않음
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // 스택이 비어있어야 유효한 괄호 문자열
    }
    
    public static int solution(String s) {
        int count = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i); // 문자열을 왼쪽으로 회전
            if (isValid(rotated)) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}
