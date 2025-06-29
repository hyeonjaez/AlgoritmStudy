class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        String[][] parkMap = new String[park.length][park[0].length()];
        
        int nowX = 0;
        int nowY = 0;
        
        for(int i = 0; i < park.length; i++){
            String[] splits = park[i].split("");
            for(int j = 0; j < splits.length; j++){
                if(splits[j].equals("S")){
                    nowX = i;
                    nowY = j;
                }
            }
            parkMap[i] = splits;
        }
        
        for(String route : routes){
            System.out.println("1 번째");
            String[] parse = route.split(" ");
            String bang = parse[0];
            int count = Integer.parseInt(parse[1]);
            int beforePosition;
            boolean flag = true;
            boolean x = true;
            if(bang.equals("E")){
                beforePosition = nowY;
                for(int i =0; i <count; i++) {
                    if(flag) {
                        beforePosition++;
                        if(!canGo(parkMap, nowX, beforePosition)) {
                            flag = false;
                        }
                    }
                }
                x =false;
                
            } else if(bang.equals("S")) {
                beforePosition = nowX;
                 for(int i =0; i <count; i++) {
                    if(flag) {
                        beforePosition++;
                        if(!canGo(parkMap, beforePosition, nowY)) {
                            flag = false;
                        }
                    }
                }
            } else if(bang.equals("W")) {
                beforePosition = nowY;
                 for(int i =0; i <count; i++) {
                    if(flag) {
                        beforePosition--;
                        if(!canGo(parkMap, nowX, beforePosition)) {
                            flag = false;
                        }
                    }
                }
                x =false;
            } else {
                beforePosition = nowX;
                 for(int i =0; i <count; i++) {
                    if(flag) {
                        beforePosition--;
                        if(!canGo(parkMap, beforePosition, nowY)) {
                            flag = false;
                        }
                    }
                }
            }
            
            if(flag){
                if(x){
                    nowX = beforePosition;    
                }else{
                    nowY = beforePosition;
                }
            }
            
            System.out.println(nowX + " " + nowY);
            
            
        }
        
        return new int[]{nowX, nowY};
    }
    
    public boolean canGo(String[][] map, int x, int y){
        if(x >=0 && y>=0 && x <map.length && y < map[0].length && !map[x][y].equals("X")){
            return true;
        }
        return false;
    }
}