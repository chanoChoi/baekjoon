import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int[] MNK = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();;
			int M = MNK[0], N = MNK[1], K = MNK[2];
			int[][] map = new int[M][N];
			boolean[][] visited = new boolean[M][N];
			int ret = 0;
			for (int i = 0; i < K; i++) {
				int[] pos = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
				map[pos[0]][pos[1]] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						ret = ret + 1;
						dfs(i, j, visited, map);
					}
				}
			}
			sb.append(ret);
			if (T != 0) {
				sb.append(System.lineSeparator());
			}
		}
		System.out.print(sb.toString());
	}

	private static void dfs(int x, int y, boolean[][] visited, int[][] map) {
		int rLen = map.length;
		int cLen = map[0].length;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= rLen || ny < 0 || ny >= cLen) continue;
			if (map[nx][ny] == 0) continue;
			if (visited[nx][ny]) continue;
			dfs(nx, ny, visited, map);
		}
	}
}