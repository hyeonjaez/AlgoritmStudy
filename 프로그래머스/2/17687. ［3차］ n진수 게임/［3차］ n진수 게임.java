class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        String temp = sb.toString();
        for (int i = p - 1; result.length() < t; i += m) {
            result.append(temp.charAt(i));
        }

        return result.toString().toUpperCase();
    }

}