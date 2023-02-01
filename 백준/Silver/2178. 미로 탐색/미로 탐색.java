import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
			map[i] = tmp;
		}
		Deque<int[]> queue = new LinkedList<>();
		visited[0][0] = 1;
		queue.addLast(new int[]{0, 0});
		while (!queue.isEmpty()) {
			int[] pos = queue.removeFirst();
			for (int i = 0; i < 4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
				if (map[nx][ny] == 0) continue;
				if (visited[nx][ny] != 0) continue;
				visited[nx][ny] = visited[pos[0]][pos[1]] + 1;
				queue.addLast(new int[]{nx, ny});
			}
		}
		System.out.println(visited[N - 1][M - 1]);
	}
}