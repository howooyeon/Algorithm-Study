class Solution {
    public String solution(String new_id) {

        // 1단계: 소문자로 변환
        String answer = new_id.toLowerCase();

        // 2단계: 허용된 문자 제외 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        // 3단계: 마침표 2번 이상 -> 하나로 치환
        answer = answer.replaceAll("\\.{2,}", ".");

        // 4단계: 처음과 끝의 마침표 제거
        answer = answer.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열이면 "a"
        if (answer.isEmpty()) {
            answer = "a";
        }

        // 6단계: 길이가 16 이상이면 15개까지만 자르기
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);

            // 끝이 . 이면 제거
            answer = answer.replaceAll("\\.$", "");
        }

        // 7단계: 길이가 2 이하이면 마지막 문자 반복
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}