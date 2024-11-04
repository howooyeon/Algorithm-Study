class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String stree : skill_trees) {
            StringBuilder filteredSkill = new StringBuilder();

            for (char c : stree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    filteredSkill.append(c);
                }
            }

            if (skill.startsWith(filteredSkill.toString())) {
                answer++;
            }
        }

        return answer;
    }
}
