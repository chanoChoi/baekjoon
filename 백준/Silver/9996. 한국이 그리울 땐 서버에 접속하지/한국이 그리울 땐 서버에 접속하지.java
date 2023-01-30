import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] target = br.readLine().split("\\*");
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String tmp = br.readLine();
			if (tmp.length() < (target[0] + target[1]).length()) {
				sb.append("NE");
			}else if (tmp.startsWith(target[0]) && tmp.endsWith(target[1])) {
				sb.append("DA");
			} else {
				sb.append("NE");
			}
			if (N != 0) {
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}