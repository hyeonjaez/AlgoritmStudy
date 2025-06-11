class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            
            if(count > 0){
                for(int j = 0; j < count; j++){
                    sb.append(i);
                }
            }
        }

         StringBuilder reverse = new StringBuilder(sb).reverse();

        sb.append(0).append(reverse);


        return sb.toString();
    }
}