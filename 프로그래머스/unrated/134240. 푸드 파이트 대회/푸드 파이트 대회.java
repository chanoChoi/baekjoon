class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = food.length - 1; i > 0; i--) {
            int count = food[i] / 2;
            while (count > 0) {
                sb.append(i);
                count = count - 1;
            }
        }
        String s = sb.toString();
        return sb.reverse() + "0" + s;
    }
}