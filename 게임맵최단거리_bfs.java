package 설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * maps는 n x m,  1 이상 100 이하
 * 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치
 * 1은 빈칸, 0은 벽
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
public class 게임맵최단거리_bfs {
	static int n, m; 
	static int[][] maps;
	static boolean[][] isVisited = new boolean[5][5];

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maps = new int[n][m];
		//지도 생성
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	
		System.out.println(bfs(0,0));

	}//main
	
	private static int bfs(int y, int x) {
		isVisited[y][x]= true;
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(new Node(y,x,1));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.y==n-1 && cur.x==m-1) return cur.cnt;
			
			for(int i=0; i<4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				
				if(ny>=0 && ny<n && nx>=0 && nx<m && maps[ny][nx] == 1 && isVisited[ny][nx] == false ) {
					isVisited[ny][nx] = true;
					queue.offer(new Node(ny,nx, cur.cnt+1));
				}
			
			}
		}
		//못가는 곳이면 -1리턴
		return -1;
	}//bfs
}

class Node{
	int y;
	int x;
	int cnt;
	
	Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
