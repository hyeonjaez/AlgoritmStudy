import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> amountList = new ArrayList<>();
        Iterator<Object> iterator = st.asIterator();
        while (iterator.hasNext()) {
            amountList.add(Integer.parseInt((String) iterator.next()));
        }

        int BNP = BNP(money, amountList);
        int TIMING = TIMING(money, amountList);

        if (BNP > TIMING) {
            System.out.println("BNP");
        } else if (BNP < TIMING) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }


    public static int BNP(int money, List<Integer> amountList) {
        int totalCount = 0;
        for (Integer amount : amountList) {
            if (amount <= money) {
                int count = (money / amount);
                money -= (count * amount);
                totalCount += count;
            }
        }

        return totalCount * amountList.get(amountList.size() - 1) + money;
    }

    public static int TIMING(int money, List<Integer> amountList) {
        int increaseCount = 0;
        int decreaseCount = 0;
        int yesterday = amountList.get(0);
        int buyCount = 0;

        for (int i = 1; i < amountList.size(); i++) {
            int today = amountList.get(i);

            if (today > yesterday) {
                increaseCount++;
                decreaseCount = 0;
            } else if (today < yesterday) {
                decreaseCount++;
                increaseCount = 0;
            } else {
                increaseCount = 0;
                decreaseCount = 0;
            }

            if (increaseCount >= 3) {
                if (buyCount != 0) {
                    money += (today * buyCount);
                }
                increaseCount = 0;
                buyCount = 0;
            } else if (decreaseCount >= 3) {
                int nowCount = money / today;
                buyCount += nowCount;
                money -= (nowCount * today);
            }
            yesterday = today;
        }

        return money + (buyCount * amountList.get(amountList.size() - 1));
    }
}