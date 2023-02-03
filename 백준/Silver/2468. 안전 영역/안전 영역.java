import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(tmp[j]);
				map[i][j] = num;
			}
		} // 입력값 초기화
		int ret = 1;
		for (int h = 1; h < 101; h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[x][y] > h && !visited[x][y]) {
						cnt = cnt + 1;
						dfs(x, y, h);
					}
				}
			}// count connected componet
			ret = Math.max(ret, cnt);
		}
		System.out.println(ret);
	}

	private static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
			if (map[nx][ny] <= h) continue;
			if (visited[nx][ny]) continue;
			dfs(nx, ny, h);
		}
	}
}