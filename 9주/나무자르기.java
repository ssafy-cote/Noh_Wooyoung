package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 높이 설정 -> 높이보다 큰 나무의 윗부분이 잘림
 원하는 길이와 가장 근접한 양만큼 잘라야함
 100000, 2000000000 -> 순차탐색 x -> 이진탐색
 */
public class 나무자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N,M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //원하는 길이
		
		int[] trees = new int[N];
		
		
		int maxLen = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(trees[i] > maxLen) maxLen = trees[i];
		}
		
		int startLen = 1;
		int midLen;
		long sum;
		while(true) {
			sum = 0;
			midLen = (int)(startLen+maxLen)/2;
			for(int i=0; i<N; i++) {
				if(trees[i]>midLen) sum += trees[i]-midLen;
			}
			
			//너무 많이잘랐으면 -> 조금만잘라야됨
			if(sum>M) startLen = midLen+1;
			else if(sum<M) maxLen = midLen-1;
			
			
			if(sum==M) {
				System.out.println(midLen);
				break;
			} else if(startLen > maxLen) { //startLen>maxLen -> startLen값을 주면 M보다 작을수도 -> maxLen이 정답
				System.out.println(maxLen);
				break;
			}
		}
		
		
		
		
		
		
	}

}
