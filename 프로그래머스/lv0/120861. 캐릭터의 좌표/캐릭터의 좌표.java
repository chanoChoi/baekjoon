import java.util.*;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("up", Arrays.asList(0, 1));
        map.put("down", Arrays.asList(0, -1));
        map.put("left", Arrays.asList(-1, 0));
        map.put("right", Arrays.asList(1, 0));
        int[] answer = new int[]{0, 0};
        for (String s : keyinput) {
            List<Integer> coordinate = map.get(s);
            int x = coordinate.get(0);
            int y = coordinate.get(1);
            
            if (Math.abs(answer[0] + x) <= Math.abs(
board[0] / 2) && Math.abs(answer[1] + y) <= Math.abs(board[1] / 2)){
                answer[0] = answer[0] + x;
                answer[1] = answer[1] + y;
            }
        }
        
        return answer;
    }
}