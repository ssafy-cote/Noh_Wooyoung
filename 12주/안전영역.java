package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
일정 높이 이하 모든 지점은 물에 잠김
N*N
빙하랑 비슷?
떨어진 덩어리 개수 구하기
bfs

1트
큐에서 꺼내면서 방문처리 하니까 메모리 초과남
-> 중복된 노드들이 큐에 들어가게 되고 메모리 초과
2트
큐에 넣을 때 방문 처리를 하면 한 번만 들어가게됨
*/
public class 안전영역 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int answer = 0;
	static int N;
	static int[][] copy;
	static Queue<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		copy = new int[N][N];
		
		StringTokenizer st;
		int maxHeight = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>maxHeight) maxHeight = arr[i][j];
			}
		}
		
		for(int i=0; i<maxHeight; i++) {
			findSplit(arr, i);
		}
		
		System.out.println(answer);
	}
	
	private static void findSplit(int[][] arr, int height) {
		int temp = 0;
		
		//복사본 생성, 주어진 높이보다 낮거나 같으면 0으로
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j] = arr[i][j];
				if(copy[i][j]<=height)copy[i][j] = 0;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(copy[i][j]>0) {
					temp++;
					queue.add(new Node(i,j));
					copy[i][j] = 0;
					while(!queue.isEmpty()) {
						Node cur = queue.poll();
						int y = cur.y;
						int x = cur.x;
						
						for(int d=0; d<4; d++) {
							int ny = y+dy[d];
							int nx = x+dx[d];
							
							if(ny>=0 && ny<N && nx>=0 && nx<N && copy[ny][nx]>0) {
								queue.add(new Node(ny,nx));
								copy[ny][nx] = 0;
							}
						}
					}//queue
				}
			}
		}
		if(temp>answer) answer = temp;
	}
	
	
	private static class Node{
		int y,x;
		Node(int y, int x){
			this.y=y;
			this.x=x;
		}
	}
}
