package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 역순으로 배열 저장
 스택 쓸 필요 x
 역순배열의 첫 번쨰(마지막)은 더 볼 건물이 없으므로 패스(인덱스 1부터 시작)
 현재 건물보다 인덱스가 작은 건물들 확인, 더 크거나 같은 건물 나올때까지 반복해서 누적

 */

public class 옥상 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		int[] reverse = new int[N];
		
		
		for(int i=0; i<N; i++) {
			reverse[N-1-i] = Integer.parseInt(br.readLine());
		}
		 
		
		long sum = 0;
		for(int i=1; i<N; i++) {
			int top = i-1; //이번에 넣는 인덱스보다 작은거부터 밑으로 쭉
			while(top>=0 && reverse[top]<reverse[i]) {
				sum+=1;
				top--;
			}
		}
		
		System.out.println(sum);
		
	}//main

}
