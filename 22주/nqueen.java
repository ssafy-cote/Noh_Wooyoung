package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nqueen {
	static int N;
	static int result = 0;
	static int[][] checker;
	
	static int[] dy = {-1,-1,0,1,1,1,0,-1,};
	static int[] dx = {0,1,1,1,0,-1,-1,-1,};
	
	static int ny, nx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for(int x=0; x<N; x++) {
			checker = new int[N][N];
			setVisit(0,x,1);
			Queen(1);
			setVisit(0,x,-1);
		}
		System.out.println(result);
		
	}//main

	//퀸 조건 만족하는지 확인
	private static void Queen(int cnt) {
		if(cnt==N) {
			result++;
		}
		for(int x=0; x<N; x++) {
			if(checker[cnt][x]==0) {//지금 보고있는 칸의 값이 0이면
				setVisit(cnt, x, 1);//1더해 저장하
				Queen(cnt+1);
				setVisit(cnt, x, -1);
			}
		}
	}
	
	private static void setVisit(int y, int x, int val) {
		checker[y][x] += val;//방문처리하고
		
		for(int i=0; i<8; i++) { //8방값 검사
			ny = y + dy[i];
			nx = x + dx[i];
			
			while(ny>=0 && ny<N && nx>=0 && nx<N) {
				checker[ny][nx] += val;
				ny = ny + dy[i];
				nx = nx + dx[i];
			}
		}
	}
	
	
}





















