import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		quard(0, 0, N);
		System.out.print(sb.toString());
	}

	private static void quard(int y, int x, int size) {
		char cur = map[y][x];
		if (size == 1) {
			sb.append(map[y][x]);
			return;
		}

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (cur != map[i][j]) {
					int half = size / 2;
					sb.append('(');
					quard(y, x, half);
					quard(y, x + half, half);
					quard(y + half, x, half);
					quard(y + half, x + half, half);
					sb.append(')');
					return;
				}
			}
		}
		sb.append(map[y][x]);
	}
}