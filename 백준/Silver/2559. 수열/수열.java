import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numsStr = br.readLine().split(" ");
		int N = Integer.parseInt(numsStr[0]);
		int K = Integer.parseInt(numsStr[1]);
		int[] arr = new int[N];
		String[] given = br.readLine().split(" ");

		int acc = 0;
		for (int i = 0; i < N; i++) {
			acc += Integer.parseInt(given[i]);
			arr[i] = acc;
		}

		int max = arr[K - 1];
		for (int i = K; i < N; i++) {
			max = Math.max(max, arr[i] - arr[i - K]);
		}
		System.out.println(max);
	}
}