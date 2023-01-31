import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N-- > 0) {
			Deque<Character> stack = new LinkedList<>();
			String give = br.readLine();
			for (char each : give.toCharArray()) {
				if (!stack.isEmpty() && stack.peekLast() == each) {
					stack.removeLast();
				} else {
					stack.addLast(each);
				}
			}
			if (stack.isEmpty()) {
				cnt = cnt + 1;
			}
		}
		System.out.print(cnt);
	}
}