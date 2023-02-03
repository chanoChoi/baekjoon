import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static int[][] map;
	static int b;
	static int w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}
		quard(0, 0, N);
		System.out.println(w);
		System.out.print(b);
	}

	private static void quard(int y, int x, int size) {
		int cur = map[y][x];
		if (size == 1) {
			if (cur == 1) {
				b = b + 1;
			} else {
				w = w + 1;
			}
			return;
		}

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (cur != map[i][j]) {
					int half = size / 2;
					quard(y, x, half);
					quard(y, x + half, half);
					quard(y + half, x, half);
					quard(y + half, x + half, half);
					return;
				}
			}
		}

		if (cur == 1) {
			b = b + 1;
		} else {
			w = w + 1;
		}
	}
}