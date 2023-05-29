import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        br.readLine().chars().forEach(i -> arr[i - 'a'] += 1);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
        System.out.println(sb.toString());
    }
}