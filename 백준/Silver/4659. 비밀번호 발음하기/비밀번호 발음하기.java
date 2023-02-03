import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		StringBuilder sb = new StringBuilder();
		while (!"end".equals(tmp = br.readLine())) {
			Map<Integer, Integer> map = new HashMap<>() {{
				put('a' - 'a', 0);
				put('e' - 'a', 0);
				put('i' - 'a', 0);
				put('o' - 'a', 0);
				put('u' - 'a', 0);
			}};

			boolean flag = false;
			boolean pFlag = false;
			int pre = -1;
			int pCnt = 2;
			int cCnt = 2;
			for (char c : tmp.toCharArray()) {
				if (--pCnt >= 0 && pre != c && map.containsKey(c - 'a')) {
					pFlag = true;
					cCnt = 2;
				} else if (--cCnt >= 0 && pre != c && !map.containsKey(c - 'a')){
					pCnt = 2;
				} else {
					flag = true;
					break;
				}
				if (c == 'e' || c == 'o') {
					pre = -1;
				} else {
					pre = c;
				}
			}
			if (!pFlag || flag) {
				sb.append(String.format("<%s> is not acceptable.%s", tmp, System.lineSeparator()));
			} else {
				sb.append(String.format("<%s> is acceptable.%s", tmp, System.lineSeparator()));
			}
		}
		System.out.println(sb.toString());
	}
}