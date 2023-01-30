import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String given = br.readLine();
        int l = 0, r = given.length() - 1;
        while (l < r) {
            char c1 = given.charAt(l++);
            char c2 = given.charAt(r--);
            if (c1 != c2) {
                System.out.print(0);
                return;
            }
        }
        System.out.print(1);
    }
}