class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int t = bandage[0];       // 연속 성공 시간
        int heal = bandage[1];    // 초당 회복
        int bonus = bandage[2];   // 추가 회복

        int maxHealth = health;
        int currentHealth = health;

        int time = 1;
        int attackIdx = 0;
        int continueCount = 0;

        int lastTime = attacks[attacks.length - 1][0];

        while (time <= lastTime) {

            // 공격 발생
            if (attackIdx < attacks.length && attacks[attackIdx][0] == time) {
                currentHealth -= attacks[attackIdx][1];
                attackIdx++;
                continueCount = 0;

                if (currentHealth <= 0) return -1;
            } else {
                // 붕대 감기
                continueCount++;
                currentHealth += heal;

                if (continueCount == t) {
                    currentHealth += bonus;
                    continueCount = 0;
                }

                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }

            time++;
        }

        return currentHealth;
    }
}