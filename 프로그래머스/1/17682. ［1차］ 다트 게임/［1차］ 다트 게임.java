class Solution {

    public int solution(String dartResult) {

        int[] scores = new int[3];
        int idx = -1;

        for (int i = 0; i < dartResult.length(); i++) {

            char ch = dartResult.charAt(i);

            // 숫자 처리
            if (Character.isDigit(ch)) {

                idx++;

                // 10 처리
                if (ch == '1' && i + 1 < dartResult.length()
                        && dartResult.charAt(i + 1) == '0') {

                    scores[idx] = 10;
                    i++;

                } else {
                    scores[idx] = ch - '0';
                }

            }

            // 보너스 처리
            else if (ch == 'S') {
                scores[idx] = (int)Math.pow(scores[idx], 1);

            } else if (ch == 'D') {
                scores[idx] = (int)Math.pow(scores[idx], 2);

            } else if (ch == 'T') {
                scores[idx] = (int)Math.pow(scores[idx], 3);
            }

            // 옵션 처리
            else if (ch == '*') {

                scores[idx] *= 2;

                if (idx > 0) {
                    scores[idx - 1] *= 2;
                }

            } else if (ch == '#') {

                scores[idx] *= -1;
            }
        }

        return scores[0] + scores[1] + scores[2];
    }
}