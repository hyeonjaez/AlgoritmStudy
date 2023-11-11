import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        char before = '0';
        int count = 0;
        for(char ch : str.toCharArray()){
            if(ch == ')' ){
                if(before == '('){
                    stack.pop();
                    count+= stack.size();
                }
                else{
                    stack.pop();
                    count++;
                }
            }
            else stack.push(ch);
            before = ch;
        }
        System.out.println(count);
    }

}