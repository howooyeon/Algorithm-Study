class Solution {
    public static int[] solution(int n, int m) {
        int gcd = gcd(n, m); // 최대공약수 구하기
        int lcm = (n * m) / gcd; // 최소공배수 구하기
        return new int[]{gcd, lcm};
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}