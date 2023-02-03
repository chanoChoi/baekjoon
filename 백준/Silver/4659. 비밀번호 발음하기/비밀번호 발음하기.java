import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		StringBuilder sb = new StringBuilder();
		while (!"end".equals(tmp = br.readLine())) {


			boolean flag = false;
			boolean pFlag = false;
			int pre = -1;
			int pCnt = 0;
			int cCnt = 0;
			for (char c : tmp.toCharArray()) {
				if (isVowel(c)) {
					pFlag = true;
					pCnt = pCnt + 1;
					cCnt = 0;
				} else {
					cCnt = cCnt + 1;
					pCnt = 0;
				}
				if (pCnt == 3 || cCnt == 3) {
					flag = true;
				}
				if (pre == c && (c != 'e' && c != 'o')) {
					flag = true;
				}
				pre = c;
			}
			if (!pFlag) flag = true;
			if (flag) {
				sb.append(String.format("<%s> is not acceptable.%s", tmp, System.lineSeparator()));
			} else {
				sb.append(String.format("<%s> is acceptable.%s", tmp, System.lineSeparator()));
			}
		}
		System.out.println(sb.toString());
	}

	private static boolean isVowel(int idx) {
		return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
	}
}