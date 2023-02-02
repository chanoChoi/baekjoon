import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static int[][] map;
	static boolean[][] visited;
	static int sx;
	static int sy;
	static int ex;
	static int ey;
	static List<Integer> ret = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] MNK = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		map = new int[MNK[0]][MNK[1]];
		visited = new boolean[MNK[0]][MNK[1]];
		int cnt = 0;
		for (int i = 0; i < MNK[2]; i++) {
			String[] posStr = br.readLine().split(" ");
			sy = Integer.parseInt(posStr[0]);
			sx = Integer.parseInt(posStr[1]);
			ey = Integer.parseInt(posStr[2]);
			ex = Integer.parseInt(posStr[3]);
			for (int j = sx; j < ex; j++) {
				for (int k = sy; k < ey; k++) {
					if (!visited[j][k]) {
						dfs(j, k);
					}
				}
			}
		} // map 내의 색칠

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (!visited[i][j]) {
					cnt = cnt + 1;
					int blockCnt = dfs2(i, j, 0);
					ret.add(blockCnt);
				}
			};
		}
		Collections.sort(ret);
		System.out.println(cnt);
		for (int each : ret) {
			sb.append(each).append(" ");
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < sx || nx >= ex || ny < sy || ny >= ey) continue;
			if (visited[nx][ny]) continue;
			dfs(nx, ny);
		}
	}

	private static int dfs2(int x, int y, int cnt) {
		visited[x][y] = true;
		cnt = cnt + 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
			if (visited[nx][ny]) continue;
			cnt = dfs2(nx, ny, cnt);
		}
		return cnt;
	}
}
