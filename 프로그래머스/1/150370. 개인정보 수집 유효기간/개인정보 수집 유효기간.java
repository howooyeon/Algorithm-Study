import java.util.*;

class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();

        // 약관 저장
        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {

            String[] split = term.split(" ");

            map.put(split[0], Integer.parseInt(split[1]));
        }

        // 오늘 날짜 총 일수 변환
        int todayDays = convertToDays(today);

        // 개인정보 검사
        for (int i = 0; i < privacies.length; i++) {

            String[] split = privacies[i].split(" ");

            String date = split[0];
            String type = split[1];

            int collectedDays = convertToDays(date);

            // 유효기간 추가
            int expireDays = collectedDays + (map.get(type) * 28);

            // 오늘 날짜 이상이면 파기
            if (expireDays <= todayDays) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // 날짜 -> 총 일수 변환
    private int convertToDays(String date) {

        String[] split = date.split("\\.");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        return (year * 12 * 28)
                + (month * 28)
                + day;
    }
}