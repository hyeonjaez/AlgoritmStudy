class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalMoney = 0;
        
        for(int i=1; i<=count; i++){
            totalMoney += Long.valueOf(i) * Long.valueOf(price);
        }
        if(totalMoney > Long.valueOf(money)){
            answer = totalMoney - Long.valueOf(money);
        }

        return answer;
    }
}