import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[26];
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			cnt[c - 'A']++;
		}
		int flag = 0;
		char mid = '0';
		for (int i = cnt.length - 1; i >= 0; i--) {
			if ((cnt[i] & 1) == 1) {
				mid = (char) (i + 'A');
				cnt[i]--;
				flag++;
				if (flag == 2) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
			}
			for (int j = 0; j < cnt[i]; j += 2) {
				sb.append((char) (i + 'A'));
				sb.insert(0, (char) (i + 'A'));
			}
		}
		if (Character.isLetter(mid)) {
			sb.insert(sb.length() / 2, mid);
		}
		System.out.println(sb);
	}
}