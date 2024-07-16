package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 M*N 종이
 색칠 -> 직사각형 k개 -> 색칠 안한 분리된 영역 생김
 왼쪽 아래가 0,0, 오른쪽 위가 M,N
 
 왼아래x,y / 오른위 x,y
 분리되는 영역 개수, 넓이 오름차순으로 정렬해서 출력

 1. 종이 생성, 색칠(true설정)
 2. 각 칸 순회, false칸 만나면 dfs시작, 분리 영역 개수 +1
 3. dfs깊이만큼 너비 증가
  
 */
public class 영역구하기 {
	static int divCnt = 0;
	static int M,N,K;
	static boolean[][] arr;
	static List<Integer> result = new ArrayList<Integer>();
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static int areaSize;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[M][N];
		
		//색칠
		for(int i=0; i<K; i++) {
			int startY, startX, endY, endX;
			st = new StringTokenizer(br.readLine());
			
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken()); 
			
			endX =  Integer.parseInt(st.nextToken());;
			endY =  Integer.parseInt(st.nextToken());;
			
			for(int y=startY; y<endY; y++) {
				for(int x=startX; x<endX; x++) {
					arr[y][x] = true;
				}
			}
		}
		
		//분리 칸 찾기
		for(int y=0; y<M; y++) {
			for(int x=0; x<N; x++) {
				if(arr[y][x] == false) {
					areaSize = 0;
					divCnt++;
					dfs(y,x);
					result.add(areaSize);
				}
			}
		}
		
//		for(int y=0; y<M; y++) {
//			System.out.println(Arrays.toString(arr[y]));
//		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(result);
		
		for(int i=0; i<result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}
		
		System.out.println(divCnt);
		System.out.println(sb.toString());
		
		
	}//main
	
	private static void dfs(int y, int x) {
		if(arr[y][x] == true) return;
		
		areaSize++;
		arr[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny>=0 && ny<M && nx>=0 && nx<N && arr[ny][nx]==false) {
				dfs(ny,nx);
			}
		}
	}//dfs
	
	
	
	
	
	
	
	
	
	
}
