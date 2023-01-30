import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String given = br.readLine();
		int targetIdx = given.indexOf("*");
		String prefix = given.substring(0, targetIdx);
		String suffix = given.substring(targetIdx + 1);

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String tmp = br.readLine();
			if (tmp.length() < prefix.length() + suffix.length()) {
				sb.append("NE");
			} else if (prefix.equals(tmp.substring(0, prefix.length())) && suffix.equals(
				tmp.substring(tmp.length() - suffix.length()))) {
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