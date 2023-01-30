import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[26];
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char c = br.readLine().charAt(0);
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }
        if (sb.length() == 0) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(sb.toString());
        }
	}
}