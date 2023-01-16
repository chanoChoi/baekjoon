class Solution {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return new int[]{a, n * m / a};
    }
}