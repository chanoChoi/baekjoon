import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(bf.readLine());
            arr[i] = n;
            sum += n;
        }
       Arrays.sort(arr);
       int n1 = 0;
       int n2 = 0;
       for (int i = 0; i < arr.length - 1; i++) {
           for (int j = i + 1; j < arr.length; j++) {
               if (sum - arr[i] - arr[j] == 100) {
                  n1 = i;
                  n2 = j;
                   break;
               }
           }
       }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i == n1 || i == n2) continue;
            sb.append(arr[i]).append("\n");
        }
        
        System.out.print(sb);
    }
}