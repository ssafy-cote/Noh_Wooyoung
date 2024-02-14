package a0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 상하좌우 중 물과 닿는 면만큼 녹아내림
 상하좌우 붙은 숫자들은 한 덩어리
 두 덩어리로 분리되는 최초의 시간?
 각 칸의 값은 0~10 
 
 재귀를 통해 melt함수 구현, 기저조건으로 덩어리 개수가 2이상이면 종료되게 설정
 
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
 
 메모리 : 230348kb
 시간 : 680ms
 */
public class 빙하 {
	
	static class Node {
		int y,x;
		Node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] glaciar;
	static int N,M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int year = 0;
	static int splits;
	static Queue<Node> queue = new ArrayDeque<Node>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행 
		M = Integer.parseInt(st.nextToken()); //열
		
		glaciar = new int[N][M];
		
		//빙하 생성
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				glaciar[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		melt(glaciar);
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(glaciar[i]));
//		}
		System.out.println(year);
		
	}//main
	
	
	private static void melt(int[][] glaciar) {
		int[][] meltArr = new int[N][M]; //인접 바다가 몇개인지 저장
		int[][] copyArr = new int[N][M];
		
		boolean isAllZero = true;
		
		splits = 0;
		//매 칸 탐색해서
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				//현재 칸이 0이 아니면
				if(glaciar[i][j]!=0) {
					for(int a=0; a<4; a++) {
						int ny=i+dy[a];
						int nx=j+dx[a];
//						if(ny<0 || ny>=N || nx<0 || nx>=M) continue; //테두리는 항상 0-> 범위 나갈 일 없음
						if(glaciar[ny][nx]==0) meltArr[i][j]++;
					}
				}
			}
		}
		
		
		
		//녹이기
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				glaciar[i][j] -= meltArr[i][j];
				if(glaciar[i][j]<0) glaciar[i][j]=0;
				copyArr[i][j] = glaciar[i][j]; //녹은 상태 복사 - 원본은 나중에 또 써야됨
				if(copyArr[i][j]!=0) isAllZero = false;
			}
		}
		
		if(isAllZero) {
			year= 0;
			return;
		}
		
		year+=1;
		
		//덩어리찾기
		A:for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(copyArr[i][j] != 0) { //0이 아닌걸 만나면 splits 1증가시키고 bfs해서 붙은 것들 0으로 처리
					splits += 1; //덩어리 찾았으므로 1증가
					if(splits>1)break A;
					queue.offer(new Node(i,j)); //현재 인덱스를 노드로 만들어 큐에 넣기
					
					//bfs
					while(!queue.isEmpty()) {						
						Node current = queue.poll();
						copyArr[current.y][current.x] = 0;
						for(int a=0; a<4; a++) {
							int ny = current.y + dy[a];
							int nx = current.x + dx[a];
//							if(ny<0 || ny>=N || nx<0 || nx>=M) continue; //범위 나갈 일 없음
							if(copyArr[ny][nx]!=0) {
								copyArr[ny][nx] = 0; //0으로 만들고
								queue.offer(new Node(ny,nx)); //큐에 넣기
							}
						}
					}
				}
			}
		}

		if(splits>1) { //기저조건
			return;
		} else {
			melt(glaciar); //덩어리 2개 이상 아니면 재귀
		}
	}//melt
}