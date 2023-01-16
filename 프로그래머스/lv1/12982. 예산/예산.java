import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int sum = 0;
        for (int n : d) {
            if (sum + n <= budget) {
                sum = sum + n;
                answer = answer + 1;
            } else {
                break;
            }
        }
        return answer;
    }
}