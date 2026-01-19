import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] array;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int targetDepth;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

        array = new int[n+1][n+1];
        visited= new boolean[n + 1];
        StringTokenizer st;
        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        targetDepth = n / 2;
        back(1, 0);

        System.out.println(result);
        
    }

    public static void back(int start, int depth){
        if(depth == targetDepth){
            diff();
        }

        for(int i = start; i < n + 1; i++){
            if(!visited[i]){
                visited[i] = true;
                back(i + 1, depth+1);
                visited[i] = false;
            }

            
        }
    }

    public static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i = 1; i < n ; i++){
            for(int j = i; j < n+ 1; j++){
                if(visited[i] == true && visited[j] == true){
                    team_start += array[i][j];
                    team_start += array[j][i];
                }else if(visited[i]==false && visited[j] == false){
                    team_link += array[i][j];
                    team_link += array[j][i];
                }
            }
        }

        int value = Math.abs(team_start - team_link);

        if(value == 0){
            System.out.println(value);
            System.exit(0);
        }
        result = Math.min(value, result);
    }

    

}