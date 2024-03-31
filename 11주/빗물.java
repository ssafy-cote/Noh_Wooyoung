package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 빗물 {
/*
 H*W
 블록높이 0~H
 빗물 고이려면 양쪽이 현재보다 높이 높아야됨
  + 양쪽 중 낮은 높이만큼이 최대
  
 행마다 오른쪽으로 쭉
 	블록 나오면 시작
 	빈칸이면 누적
 	블록이면 패스
스택?
스택이 비어있는데 값이 0이면 패스
  	1이면 넣기
다음 0들을 계속 넣음
1나오면 안에있는 0 개수만큼 누적

 */
	static Stack<Integer> stk = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R,C;
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		
		st = new StringTokenizer(br.readLine());
		
		for(int c=0; c<C; c++) {
			int height = Integer.parseInt(st.nextToken());
			for(int r=0; r<height; r++) {
				arr[r][c] = 1;
			}
		}
		
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		int cnt = 0;
		
		for(int r=0; r<R; r++) {
			stk.clear();
			for(int c=0; c<C; c++) {
				int cur = arr[r][c];
				if(stk.isEmpty() && cur==0)continue;
				if(cur==1) { //1나오면 싹 비우는데 0개수만큼 누적, 마지막에 다시 1넣기
					while(!stk.isEmpty()) {
						int top = stk.pop();
						if(top==0) cnt++; 
					}
					stk.add(cur);
				}else {//0이면 스택 비어있는 상태 아니면 넣기
					if(!stk.isEmpty()) {
						stk.add(cur);
					}
				}
			}
		}
		System.out.println(cnt);
		
		
		
	}

}
