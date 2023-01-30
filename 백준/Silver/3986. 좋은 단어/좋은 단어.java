import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            Deque<Character> stack = new LinkedList<>();
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                if (!stack.isEmpty() && stack.peekLast() == c) {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }
            if (stack.isEmpty()) {
                cnt = cnt + 1;
            }
        }
        System.out.println(cnt);
    }
}