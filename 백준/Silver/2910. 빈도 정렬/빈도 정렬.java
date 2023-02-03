import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NC = br.readLine().split(" ");
		int N = Integer.parseInt(NC[0]);
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int mx = 0;

		String[] give = br.readLine().split(" ");
		for (String each : give) {
			int tmp = Integer.parseInt(each);
			if (map.containsKey(tmp)) {
				int n = map.get(tmp);
				map.put(tmp, n + 1);
				mx = Math.max(mx, n + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		int secondMx = 0;
		StringBuilder sb = new StringBuilder();
		while (mx != 0) {
			for (Map.Entry<Integer, Integer> item : map.entrySet()) {
				if (item.getValue() == mx) {
					for (int i = 0; i < mx; i++) {
						sb.append(item.getKey()).append(" ");
					}
				} else if (item.getValue() < mx) {
					secondMx = Math.max(secondMx, item.getValue());
				}
			}
			if (secondMx == 0)
				break;
			mx = secondMx;
			secondMx = 0;
		}
		System.out.print(sb.substring(0, sb.length() - 1));
	}
}