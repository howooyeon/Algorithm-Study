public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0; // 단어별로 인덱스를 추적합니다.

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                index = 0; // 공백을 만나면 인덱스를 리셋합니다.
            } else {
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
                index++; // 문자를 처리할 때마다 인덱스를 증가시킵니다.
            }
        }

        return answer.toString();
    }
}
