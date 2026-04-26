class Solution {
    public int solution(int[][] signals) {

        int n = signals.length;

        // 각 cycle LCM 구하기
        int lcm = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            lcm = lcm(lcm, cycle);
        }

        // 1 ~ LCM까지만 탐색
        for (int t = 1; t <= lcm; t++) {
            boolean allYellow = true;

            for (int[] s : signals) {
                int g = s[0];
                int y = s[1];
                int r = s[2];

                int cycle = g + y + r;

                int cur = t % cycle == 0 ? cycle : t % cycle;

                // 노란불: (g, g+y]
                if (!(cur > g && cur <= g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) return t;
        }

        return -1;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}