package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 k원 만드는 개수 = 이전 동전으로 k원 만드는 개수 + (k-현재동전)개수
 */
public class 동전 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];

			dp[0] = 1;
			
			for(int coin:coins) {
				for(int k=coin; k<M+1; k++) {
					dp[k] += dp[k-coin];
				}
			}
//			System.out.println(Arrays.toString(dp));
//			System.out.println(dp[M]);
			sb.append(dp[M]).append("\n");
			
		}//tc
		System.out.println(sb);
	}

}
