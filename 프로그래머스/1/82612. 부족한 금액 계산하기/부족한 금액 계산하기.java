class Solution {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        long price2 = price;
        long result = 0;
        for(long i = 1; i <= count; i++) {
            totalPrice += price * i;
        }

        if(money >= totalPrice) {
            result = 0;
        } else {
            result = totalPrice - money;
        }

        return result;
    }
}