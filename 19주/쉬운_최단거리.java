package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int startY, startX;
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,m;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		int[][] map = new int[n][m];
		boolean[][] isVisited = new boolean[n][m];
		int[][] result = new int[n][m];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				result[i][j] = -1; //결과 배열 모두 -1로 초기화
				map[i][j] = Integer.parseInt(st.nextToken()); //갈 수 없는 땅은 0으로 결과배열에 저장
				
				if(map[i][j]==0) result[i][j]=0;
				if(map[i][j]==2) {
					startY = i;
					startX = j;
				}
			}
		}
		
		queue.add(new Node(startY, startX, 0));
		isVisited[startY][startX] = true;
		result[startY][startX] = 0;
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int y = current.y;
			int x = current.x;
			int dist = current.dist;
			
			for(int dir=0; dir<4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if( ny>=0 && ny<n && nx>=0 && nx<m && isVisited[ny][nx]==false && map[ny][nx] != 0) {
					isVisited[ny][nx] = true;
					result[ny][nx] = dist+1;
					queue.add(new Node(ny, nx, dist+1));
				}
			}
		}
	
		 for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                System.out.print(result[i][j]);
	                if (j < m - 1) {
	                    System.out.print(" ");
	                }
	            }
	            System.out.println();
	        }
	}
	private static class Node{
		int y,x,dist;
		Node(int y, int x, int dist){
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

}
