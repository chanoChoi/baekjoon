import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = br.readLine().charAt(0);
            cnt[ch - 'a']++;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            int cur = cnt[i];
            if (cur >= 5) {
                sb.append((char) (i + 'a'));
                flag = true;
            }
        }

        if (!flag) {
            sb.append("PREDAJA");
        }

        System.out.print(sb.toString());
    }
}