import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] give = br.readLine().split(" ");
		int A = Integer.parseInt(give[0]);
		int B = Integer.parseInt(give[1]);
		int C = Integer.parseInt(give[2]);

		long l = helper(A, B, C);
		System.out.println(l);
	}

	private static long helper(int a, int b, int c) {
		if (b == 1) return a % c;
		long num = helper(a, b / 2, c);
		num = num * num % c;
		if ((b & 1) == 1) {
			num = num * a % c;
		}
		return num;
	}
}