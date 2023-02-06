import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] give = br.readLine().split(" ");
		int X = Integer.parseInt(give[0]);
		int Y = Integer.parseInt(give[1]);
		map = new int[X][Y];
		for (int i = 0; i < X; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(""))
				.map(x -> {
					if (x.charAt(0) == 'c') {
						return 0;
					} else {
						return -1;
					}
				}).mapToInt(Integer::intValue)
				.toArray();
			map[i] = tmp;
		}

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if (map[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int[] m : map) {
			for (int n : m) {
				sb.append(n).append(" ");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y) {
		int cur = map[x][y];
		for (int i = y + 1; i < map[0].length; i++) {
			if (map[x][i] == 0)
				break;
			if (map[x][i] != -1)
				break;
			map[x][i] = cur + 1;
			dfs(x, i);
		}
	}
}