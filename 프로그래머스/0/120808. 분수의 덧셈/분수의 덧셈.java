import java.math.BigInteger;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int resultNumer = numer1 * denom2 + numer2 * denom1;
        int resultDenom = denom1 * denom2;

        BigInteger gcd = BigInteger.valueOf(resultNumer).gcd(BigInteger.valueOf(resultDenom));

        resultNumer /= gcd.intValue();
        resultDenom /= gcd.intValue();

        int[] answer = {resultNumer, resultDenom};
        return answer;
    }
}
