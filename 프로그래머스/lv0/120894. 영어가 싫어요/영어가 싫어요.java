import java.util.*;

class Solution {
    public long solution(String numbers) {
        if (numbers.length() < 3)return 0; 
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        long answer = 0;
        int idx = 0;
        while (idx < numbers.length()) {
            int start = 3;
            String substr = numbers.substring(idx, idx + start);
            while (idx + start + 1 <= numbers.length() && !map.containsKey(substr)) {
                start = start + 1;
                substr = numbers.substring(idx, idx + start);
            }
            answer = answer * 10 + map.get(substr);
            idx = idx + start;
        }
        return answer;
    }
}