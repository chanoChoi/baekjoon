import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		String ret= quard(0, 0, N);
		System.out.println(ret);
	}

	private static String quard(int y, int x, int size) {
		if (size == 1) return String.valueOf(map[y][x]);
		StringBuilder ret = new StringBuilder();
		char b = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] != b) {
					ret.append('(');
					ret.append(quard(y, x, size / 2));
					ret.append(quard(y, x + size / 2, size / 2));
					ret.append(quard(y + size / 2, x, size / 2));
					ret.append(quard(y + size / 2, x + size / 2, size / 2));
					ret.append(')');
					return ret.toString();
				}
			}
		}
		return String.valueOf(map[y][x]);
	}
}