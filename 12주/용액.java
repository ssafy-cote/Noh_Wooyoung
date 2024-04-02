package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 순차정렬
 2개 섞어서 0에 가장 가깝게
 [-,-,-,+,+,+,+...,+]
 음수,양수 존재 가능
 
  
 1트
 조합 nC2
 했는데 시간초과남
 100000*99999/2 = 4,999,950,000
 
 2트
 투포인터
 양쪽 끝에서 시작
 left, right인덱스의 값을 합치고 기존에 저장된 값과 비교
 절댓값이 더 작아졌으면 값 갱신
 아니면 종료 
 */
public class 용액 {
	static int result = Integer.MAX_VALUE;
	static int val1,val2;
	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(arr));
		
		int left = 0;
		int right = N-1;
		int temp = 0;
		while(left<right) {
			temp = arr[left]+arr[right];
			
			if(Math.abs(temp)<result) {
				result = Math.abs(temp);
				val1 = arr[left];
				val2 = arr[right];
				if(result==0)break;
			}
			
			if(temp>0) right--;
			else left++;
		}
		
		System.out.println(val1 + " " + val2);
	}
}
