import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] given = br.readLine().split(" ");
		int[] psum = new int[Integer.parseInt(given[0]) + 1];
		int N = Integer.parseInt(given[1]);
		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();

		for (int i = 1; i <= arr.length; i++) {
			psum[i] = psum[i - 1] + arr[i - 1];
		}
		int max = -10_000_000;
		for (int i = N; i < psum.length; i++) {
			max = Math.max(psum[i] - psum[i - N], max);
		}
		System.out.println(max);
	}
}