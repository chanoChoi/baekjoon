import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[101];
		String[] costs = br.readLine().split(" ");
		int total = 0;
		for (int i = 0; i < 3; i++) {
			String[] period = br.readLine().split(" ");
			int start = Integer.parseInt(period[0]);
			int end = Integer.parseInt(period[1]);
			for (int j = start; j < end; j++) {
				cnt[j]++;
			}
		}
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] == 1) {
				total += Integer.parseInt(costs[0]);
			} else if (cnt[i] == 2) {
				total += Integer.parseInt(costs[1]) * 2;
			} else if (cnt[i] == 3) {
				total += Integer.parseInt(costs[2]) * 3;
			}
		}
		System.out.print(total);
	}
}