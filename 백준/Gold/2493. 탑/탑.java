import java.io.*;
import java.util.*;

public class Main {
    static int[] array;
    static int[] result;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            array = new int[n];
            result = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<Top> stack = new Stack<>();


            for (int i = 0; i < n; i++) {
                int now = Integer.parseInt(st.nextToken());
                if (stack.isEmpty()) {
                    result[i] = 0;
                    stack.push(new Top(i + 1, now));
                    continue;
                }

                while (true) {
                    if(stack.isEmpty()){
                        result[i] = 0;
                        stack.push(new Top(i + 1, now));
                        break;
                    }

                    if (stack.peek().height < now){
                        stack.pop();
                    }else{
                        result[i] = stack.peek().number;
                        stack.push(new Top(i + 1, now));
                        break;
                    }
                }
            }

            for (int data : result) {
                System.out.print(data + " ");
            }
        }
    }



}

class Top {
    int number;
    int height;

    public Top(int number, int height) {
        this.number = number;
        this.height = height;
    }
}
