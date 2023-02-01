import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(tmp[j]);
				map[i][j] = num;
			}
		}
		int max = 1;
		for (int i = 1; i < 101; i++) {
			int[][] tmp = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) {
						tmp[j][k] = 0;
					} else {
						tmp[j][k] = 1;
					}
				}
			}
			int ret = 0;
			boolean[][] visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (tmp[j][k] == 1 && !visited[j][k]) {
						ret = ret + 1;
						dfs(j, k, visited, tmp);
					}
				}
			}
			max = Math.max(max, ret);
		}
		System.out.println(max);
	}

	private static void dfs(int x, int y, boolean[][] visited, int[][] map) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
			if (map[nx][ny] == 0) continue;
			if (visited[nx][ny]) continue;
			dfs(nx, ny, visited, map);
		}
	}
}
