import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] given = br.readLine().split(" ");
		int N = Integer.parseInt(given[0]);
		int K = Integer.parseInt(given[1]);
		Map<String, Integer> keyName = new HashMap<>();
		Map<Integer, String> keyNum = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			keyName.put(name, i);
			keyNum.put(i, name);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= K; i++) {
			String strOrInt = br.readLine();
			if (Character.isLetter(strOrInt.charAt(0))) {
				sb.append(keyName.get(strOrInt));
			} else {
				int num = Integer.parseInt(strOrInt);
				sb.append(keyNum.get(num));
			}
			if (i != K) {
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}