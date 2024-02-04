class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char currentChar = my_string.charAt(i);

            if (currentChar >= 'A' && currentChar <= 'Z') {
                answer.append(Character.toLowerCase(currentChar));
            } else {
                answer.append(Character.toUpperCase(currentChar));
            }
        }

        return answer.toString();
    }
}
