package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 일반 조합으로 푸니까 시간초과 -> dp조합으로 사용
 * nCr - n-1Cr-1 + n-1Cr
 * 
 * 13272kb, 124ms
 */

public class 다리놓기 {
    static int n, m, T;
    static int[][] dp;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // r
            m = Integer.parseInt(st.nextToken()); // n
            dp = new int[m + 1][n + 1];

            result  = comb(m, n);
            // for (int i = 0; i < m; i++) {
            //     System.out.println(Arrays.toString(dp[i]));
            // }
            System.out.println(result);
        }
    }

    private static int comb(int m, int n) {
        // 계산한 값이 있으면
        if (dp[m][n] > 0) {
            return dp[m][n];
        } else if (m == n || n == 0) {
            dp[m][n] = 1;
            return dp[m][n];
        } else {
            return dp[m][n] = comb(m - 1, n - 1) + comb(m - 1, n);
        }
    }
}