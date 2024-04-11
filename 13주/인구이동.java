package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 n*n
 각 칸에 나라 1개, A[r][c]명의 인구
 인접 나라 사이에 국경선 존재
 모든 나라는 1*1
 
 [인구 이동]
 상하좌우 인접 인구차 L~R사이 -> 국경선 하루 오픈
 모두 열었으면 인구 이동
 연합의 각 칸 인구수 = (연합 인구수)/(연합 이루는 칸 개수) 소수점 버림
 연합 해체, 국경선 닫기
 
 1줄요약 
 확인 조건만족 개방 인구N빵 해체
 
 1. 방문배열 사용, 매 시작 칸 큐에 넣기
 2. 인접 칸과 차이가 L이상 R이하인지 확인, bfs, 넣을 때 방문처리
 2. 조건 만족하면 개방
 3. 탐색 후 모두 개방했으면 N빵
 4. 이동 없을 때까지 반복
 */

public class 인구이동 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int N,L,R;
	static int[][] arr;
	static boolean[][] isVisited;
	static Queue<Node> queue = new ArrayDeque<Node>();
	static Queue<Node> queue2 = new ArrayDeque<Node>(); //N빵할 좌표 저장용 큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //n*n
		L = Integer.parseInt(st.nextToken()); //최소차
		R = Integer.parseInt(st.nextToken()); //최대차
		
		arr = new int[N][N]; //인구수
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		boolean flag = false; 
		
		while(true) {
			flag = true;
			isVisited = new boolean[N][N];//방문확인
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//매 좌표마다 반복
					if(isVisited[i][j]==false) {
						queue.add(new Node(i,j,arr[i][j]));
						queue2.add(new Node(i,j,arr[i][j]));
						isVisited[i][j] = true;
					}
					int temp = arr[i][j]; //시작칸 값을 초기값으로 넣고

					while(!queue.isEmpty()) {
						Node cur = queue.poll();
						int y = cur.y;
						int x = cur.x;
						int val = cur.val;
//						System.out.print(val + " ");
						for(int d=0; d<4; d++) {
							int ny = y + dy[d];
							int nx = x + dx[d];
							
							//인접 칸이 범위 내, 방문x, 오차 이내면 큐에 넣기
							if(ny>=0 && ny<N && nx>=0 && nx<N && isVisited[ny][nx]==false && Math.abs(arr[ny][nx]-val)>=L && Math.abs(arr[ny][nx]-val)<=R) {
								//현재 칸이 다음 칸과 다르면 이동해야되니까 다음 반복도 실행되게 false
								if(val != arr[ny][nx]) flag = false;
								queue.add(new Node(ny,nx,arr[ny][nx]));
								queue2.add(new Node(ny,nx,arr[ny][nx]));
								
								temp += arr[ny][nx];
								isVisited[ny][nx] = true;
							}
						}
					}//bfs
					
					
//					System.out.println("queue size: "+queue2.size());
					
					if(queue2.size()==0)continue;
					int divN = temp/queue2.size();
					
					while(!queue2.isEmpty()) {
						Node cur = queue2.poll();
						arr[cur.y][cur.x] = divN;
					}
					queue2.clear();
				}
				
				
				
			}
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			if(flag==true)break;
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}//main
	
	private static class Node{
		int y,x,val;
		Node(int y, int x, int val){
			this.y = y;
			this.x = x;
			this.val = val;
		}
	}

}
