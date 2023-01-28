import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);
        int[][] matrix = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                matrix[i][j] = Integer.parseInt(sArr[j]);
            }
        }
        
        for (int i = 0; i < R; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                matrix[i][j] += Integer.parseInt(sArr[j]);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}