import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException { // 초과시 i - 1 + 'a' or i - 1 + 'A'
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (char ch : br.readLine().toCharArray()) {

            if (!Character.isLetter(ch)) {
                sb.append(ch);
            }

            char cur = (char) (ch + 13);
            if (Character.isLowerCase(ch)) {
                if (cur > 'z') {
                    sb.append((char) (cur - 'z' - 1 + 'a'));
                } else {
                    sb.append(cur);
                }
            } else if (Character.isUpperCase(ch)) {
                if (cur > 'Z') {
                    sb.append((char) (cur - 'Z' - 1 + 'A'));
                } else {
                    sb.append(cur);
                }
            }
        }
        System.out.print(sb.toString());
    }
}