/*
6
(())())
(((()())()
(()())((()))
NO
NO
YES
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String s = br.readLine();
            Deque<Character> stack = new LinkedList<>();
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.addLast(c);
                    continue;
                }
                if (stack.isEmpty() || stack.removeLast() == '(' && c != ')') {
                    sb.append("NO").append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag && stack.isEmpty()) sb.append("YES").append("\n");
            else if (!flag && !stack.isEmpty()) sb.append("NO").append("\n");
        }
        br.close();
        System.out.print(sb.toString());
    }
}