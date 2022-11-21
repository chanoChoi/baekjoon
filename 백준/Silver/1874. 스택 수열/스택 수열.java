//5
//1
//2
//5
//3
//4
// NO

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = N; i >= 1; i--) {
            stack1.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            while (!stack1.isEmpty() && n >= stack1.peekLast()) {
                stack2.addLast(stack1.removeLast());
                sb.append("+\n");
            }
            if (!stack2.isEmpty() && stack2.peekLast() == n) {
                stack2.removeLast();
                sb.append("-\n");
            } else if (stack2.isEmpty() || stack2.peekLast() > n) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print(sb.toString());
    }
}