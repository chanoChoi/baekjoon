import java.util.*;
import java.util.stream.*;
// 1 1 1 2 2 3 3
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int idx = score.length;
        while (idx >= m) {
            answer = answer + (score[idx - m] * m);
            idx -= m;
        }
        
        return answer;
    }
}
// 최저점수의 사과를 하나로 몰아야 한다.
// 112, 224, 444, 444
