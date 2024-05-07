class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            String[] split = skillTree.split("");
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < split.length; i++) {
                if (skill.contains(split[i])) {
                    stringBuilder.append(split[i]);
                }
            }
            boolean flag = false;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (skill.charAt(i) != stringBuilder.toString().charAt(i)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                answer += 1;
            }
        }
        return answer;
    }
}