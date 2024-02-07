package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1. 한 번에 계단 하나 or 두개
 * 2. 연속으로 계단 3개 X
 * dp[i] = stairs[i] + stairs[i-1] +  dp[i-3]
 * dp[i] = stairs[i] + dp[i-2]
 * */
public class 계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(b.readLine());
		int[] stairs = new int[n+1];
		int[] dp = new int[n+1];

		//계단 생성
		for(int i=1; i<n+1; i++) {
			stairs[i] = Integer.parseInt(b.readLine());
		}

		if(n==1) {
			System.out.println(stairs[1]);
		}else if(n==2) {
			System.out.println(stairs[1]+stairs[2]);
		}else {

			dp[1] = stairs[1];
			dp[2] = stairs[1] + stairs[2];

			for(int i=3; i<n+1; i++ ) {
				dp[i] = Math.max(stairs[i]+stairs[i-1]+dp[i-3], stairs[i]+dp[i-2]);
			}


			System.out.println(dp[n]);

		}


	}

}
