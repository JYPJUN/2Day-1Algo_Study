import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_240720_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(result);
    }
}
