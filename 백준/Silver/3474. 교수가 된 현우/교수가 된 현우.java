import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0 ){
            int N = Integer.parseInt(br.readLine());
            int num = 5;
            int cnt = 0;
            while (num <= N) {
                cnt = cnt + N / num;
                num = num * 5;
            }
            sb.append(cnt).append(System.lineSeparator());
        }
        System.out.print(sb.substring(0, sb.length() - 1));
    }
}