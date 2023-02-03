import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		while (T-- > 0) {
			String tmp = br.readLine();
			for (int i = 0; i < tmp.length(); i++) {
				char c = tmp.charAt(i);
				if (Character.isDigit(c)) {
					StringBuilder sb = new StringBuilder();
					sb.append(c);
					while (i + 1 < tmp.length() && Character.isDigit(tmp.charAt(i + 1))) {
						if (sb.charAt(0) == '0') {
							sb.delete(0, 1);
						}
						sb.append(tmp.charAt(i + 1));
						i = i + 1;
					}
					list.add(sb.toString());
				}
			}
		}
		list.sort((o1, o2) -> (o1.length() == o2.length()) ? o1.compareTo(o2) :
			o1.length() - o2.length());
		StringBuilder sb = new StringBuilder();
		for (String each : list) {
			sb.append(each).append(System.lineSeparator());
		}
		System.out.print(sb.toString().substring(0, sb.length() - 1));
	}
}