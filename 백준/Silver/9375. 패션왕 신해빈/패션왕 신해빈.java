import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int K = Integer.parseInt(br.readLine());
            while (K-- > 0) {
                String[] give = br.readLine().split(" ");
                map.put(give[1], map.getOrDefault(give[1], 1) + 1);
            }
            int res = 1;
            for(int each : map.values()) {
                res *= each;
            }
            sb.append(res - 1);
            if (N != 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}