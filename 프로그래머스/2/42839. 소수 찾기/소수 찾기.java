import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Solution {
    public Set<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        recursive("", numbers);

        Iterator<Integer> iterator = set.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (isPrimeNumber(iterator.next())) {
                count++;
            }
        }
        return count;
    }
    
    public void recursive(String comb, String others) {
        if (!Objects.equals(comb, "")) {
            set.add(Integer.parseInt(comb));
        }

        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    public boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}