class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (prime[i]) continue;
            for (int j = i * 2; j <= n; j = j + i) {
                prime[j] = true;
            }
        }
        int cnt = 0;
        for (boolean p : prime) {
            if (!p) cnt = cnt + 1;
        }
        
        return cnt;
    }
}