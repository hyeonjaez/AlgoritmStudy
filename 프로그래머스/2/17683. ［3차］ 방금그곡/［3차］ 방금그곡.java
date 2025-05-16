import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = replaceString(m);
        
        int maxPlayTime = -1;
        
        boolean isFlag = false;
        for(String musicInfo : musicinfos){
            String[] split = musicInfo.split(",");
            int startTime = getTime(split[0]);
            int endTime = getTime(split[1]);
            String title = split[2];
            String music = replaceString(split[3]);
            int playTime = endTime - startTime;
            
            
            String playedMusic = getPlayedMusic(music, playTime);
            
            if(playedMusic.contains(m)) {
                
                if(playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        
        return answer;
    }
    
    public String getPlayedMusic(String str, int time){
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < time; i++) {
            sb.append(str.charAt(i % len));
        }
        return sb.toString();
}
    
    
    public int getTime(String time){
        String split[] = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    public String replaceString(String target){
        return target.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b");
    }
}