//2
//I am happy today
//We want to win the first prize
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        while (N-- > 0) {
            String[] words = br.readLine().split(" ");
            for (String w : words) {
                StringBuilder sb = new StringBuilder();
                sb.append(w).reverse();
                res.append(sb.toString() + " ");
            }
            res.append("\n");
        }
        br.close();
        bw.write(res.toString());
        bw.flush();
        bw.close();
    }
}