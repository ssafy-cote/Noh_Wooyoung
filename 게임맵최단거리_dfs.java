package 설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/*
 * maps는 n x m,  1 이상 100 이하
 * 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치
 * 1은 빈칸, 0은 벽
 * 
 * 기저조건 : (n,m)에 도착 or 가는 방법 없음
 * 
 입력값
 5 5
 1 0 1 1 1 
 1 0 1 0 1
 1 0 1 1 1
 1 1 1 0 1
 0 0 0 0 1
 
 5 5
 1 0 1 1 1 
 1 0 1 0 1
 1 0 1 1 1
 1 1 1 0 0
 0 0 0 0 1
 */
public class 게임맵최단거리_dfs {
	static int minCnt=Integer.MAX_VALUE;
	static int n, m; 
	static int[][] maps;
	static boolean[][] isVisited;

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maps = new int[n][m];
		isVisited = new boolean[n][m];
		//지도 생성
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,1);
		if(minCnt == Integer.MAX_VALUE) minCnt = -1;
		System.out.println(minCnt);

	}
	private static void dfs(int y, int x, int cnt) {
		//기저조건 - 목표지점까지 도달
		if( y==n-1 && x==m-1 ) {
			//현 dfs값이 더 작다면 minCnt값 변경
			if(cnt < minCnt) minCnt = cnt;
			return;
		}
		//목표 지점까지 못갔으면 사방탐색
		for(int dir=0; dir<4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			//범위 내에 있고, 방문하지 않았고, 다음 좌표가 1이면 
			if(ny>=0 && ny<5 && nx>=0 && nx<5 && isVisited[ny][nx] != true && maps[ny][nx]==1 ) {
				isVisited[ny][nx] = true;
				dfs(ny, nx, cnt+1);
				isVisited[ny][nx] = false;
			} 

		}
	}
}
