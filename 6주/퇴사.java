package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
메모리 : 11576kb
시간 : 80ms

 T = 상담에 걸리는 시간
 P = 받는 금액
 t일이 걸리는 상담이라면 현재~현재 + t-1일까지 시간 소요
  
 i+T[i]일까지 일해서 번 최대 돈 = i일까지의 최대 돈 + n일 뒤에 받을 돈(일하는 경우), i+T[i]일까지의 일한 돈(일 안한 경우)
 */
public class 퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		dp = new int[N+1];
		
		StringTokenizer st;
		
		//정보 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<N; i++) {
			if(i + T[i] <= N) { //근무일을 넘어가지 않으면
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			}
			//다음날에 변동 없으면 전날의 값 사용
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		
		System.out.println(dp[N]);
		
		
		
		
	}
}
