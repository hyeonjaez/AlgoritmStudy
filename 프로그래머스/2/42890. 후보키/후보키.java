import java.util.*;
class Solution {
    List<List<Integer>> candidateKeys = new ArrayList<>();
    String[][] relation;
    int rowCount;
    int colCount;
    public int solution(String[][] relation) {
        this.relation = relation;
        rowCount = relation.length;
        colCount = relation[0].length;

        for (int size = 1; size <= colCount; size++) {
            combination(0, size, new ArrayList<>());
        }

        return candidateKeys.size();
    }

    public void combination(int start, int targetSize, List<Integer> selected) {
        if (selected.size() == targetSize) {
            if (isMinimal(selected) && isUnique(selected)) {
                candidateKeys.add(new ArrayList<>(selected));
            }
            return;
        }

        for (int i = start; i < colCount; i++) {
            selected.add(i);
            combination(i + 1, targetSize, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public boolean isUnique(List<Integer> selected) {
        Set<String> set = new HashSet<>();

        for (int r = 0; r < rowCount; r++) {
            StringBuilder sb = new StringBuilder();

            for (int col : selected) {
                sb.append(relation[r][col]).append("|");
            }

            if (!set.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }

    public boolean isMinimal(List<Integer> selected) {
        for (List<Integer> key : candidateKeys) {
            if (selected.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}