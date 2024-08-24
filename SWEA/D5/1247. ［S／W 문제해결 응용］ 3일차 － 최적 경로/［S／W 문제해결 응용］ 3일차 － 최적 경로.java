import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static Company company;
    static Home home;
    static Customer[] customers;
    static Customer[] selecteCustomer;
    static boolean[] isSelected;
    static int sum;
    static int minResult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= testCount; tc++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            company = new Company(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Home(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customers = new Customer[n];
            for (int i = 0; i < n; i++) {
                customers[i] = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            selecteCustomer = new Customer[n];
            isSelected = new boolean[n];
            minResult = Integer.MAX_VALUE;

            back(0);

            sb.append("#").append(tc).append(" ").append(minResult).append("\n");
        }

        System.out.println(sb);


    }

    public static void back(int depth) {
        sum = 0;
        if (depth == n) {
            Customer customer = selecteCustomer[0];

            sum += Math.abs(company.x - customer.x) + Math.abs(company.y - customer.y);

            Customer lastCustomer = selecteCustomer[selecteCustomer.length - 1];
            sum += Math.abs(home.x - lastCustomer.x) + Math.abs(home.y - lastCustomer.y);

            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(selecteCustomer[i].x - selecteCustomer[i + 1].x) + Math.abs(selecteCustomer[i].y - selecteCustomer[i + 1].y);
            }

            minResult = Math.min(sum, minResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isSelected[i]) {
                selecteCustomer[depth] = customers[i];
                isSelected[i] = true;
                back(depth + 1);
                isSelected[i] = false;
            }
        }
    }
}

class Company {
    int x;
    int y;

    public Company(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Home {
    int x;
    int y;

    public Home(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Customer {
    int x;
    int y;

    public Customer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}