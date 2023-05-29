import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = br.readLine().charAt(0);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (item.getValue() >= 5) {
                sb.append(item.getKey());
                flag = true;
            }
        }

        if (!flag) {
            sb.append("PREDAJA");
        }

        System.out.print(sb.toString());
    }
}