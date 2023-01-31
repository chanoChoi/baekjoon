import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] materials = new int[N];
        String[] arr = br.readLine().split(" ");
        while (N-- > 0) {
            materials[N] = Integer.parseInt(arr[N]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int each : materials) {
            if (map.containsKey(M - each)) {
                cnt++;
            } else {
                map.put(each, each);
            }
        }
        System.out.print(cnt);
	}
}