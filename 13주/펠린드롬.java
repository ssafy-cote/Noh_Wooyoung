package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 자연수 N개(한 숫자), 질문 M번
 S=시작 인덱스+1, E=끝인덱스+1
 
 <1트>
 투포인터
 시작, 끝 인덱스 1씩 바꾸면서 같은지 확인
 다르면 아니다 말하고 종료
 시작>=끝 되면 종료
 시간초과남
 */
public class 펠린드롬 {
	static int N,S,E,M;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		
		//질문 시작
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
//			System.out.println("start:"+start+" end:"+end);
			
			boolean isPelindrome = true;
			while(start<end) {
//				System.out.println(arr[start]+" "+arr[end]);
				if(arr[start] != arr[end]) {
					isPelindrome = false;
					break;
				}
				
				++start;
				--end;
			}
			
			if(isPelindrome) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
		
	}

}
