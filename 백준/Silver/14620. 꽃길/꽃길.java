import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1,-1,0,0};
    static int answer = Integer.MAX_VALUE;
    static int[][] array;
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;

        for(int i = 0; i <n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);




    }

    static void dfs(int depth, int sum){
        if(sum >= answer){
            return;
        }

        if(depth == 3){
            answer = Math.min(sum, answer);
        }else{
            for(int i = 1; i<n-1; i++){
                for(int j = 1; j <n-1; j++){
                    if(!visited[i][j]&& isVist(i, j)){
                        int cost = sumCost(i, j);
                        dfs(depth+ 1, sum+cost);
                        clearVisit(i, j);
                    }
                }
            }
        }
    }
    
    static boolean isVist(int x, int y){
        for(int i =0 ; i<4; i++){
            if(visited[x + dx[i]][y + dy[i]]){
                return false;
            }
        }
        return true;
    }

    static int sumCost(int x, int y ){
        int sum = array[x][y];
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            sum += array[x+dx[i]][y+dy[i]];
            visited[x + dx[i]][y + dy[i]] = true;
        }
        return sum;
    }

    static void clearVisit(int x, int y){
        for(int i = 0 ; i < 4; i++){
            visited[x + dx[i]][y + dy[i]] = false;
        }
        visited[x][y] = false;
    }

    
    
    
}