package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 사과 먹으면 늘어남
 좌상단 시작, 초기 길이 1
 
 몸길이 늘려 머리 다음칸으로,
 	벽이나 내 몸이면 종료
 	사과있으면 사과 먹고 꼬리 안움직임(길이 +1)
 	사과 없으면 꼬리 줄여서 당김(몸길이 유지)
 
 n*n
 사과 k개
 	행 열
 방향변환 횟수 L
 	처음에 오른쪽 향함
 	X(시작 후 x초 지난 뒤) C(왼쪽이면 L, 오른쪽 D)
 <1트>	
 dfs로 꼬리값 0으로 바꿔주면 됨 -> 안됨
 1 1
 1 1 이런 경우 dfs로 하면 제대로 꼬리 못찾음
 
 <2트>
 dfs대신 큐 사용
 매 초마다 머리를 큐에 넣음
 사과 아니면 큐에서 하나 빼고 그것이 꼬리가됨
 꼬리의 좌표를 0으로 바꿔준다
 */
public class 뱀3 {
	//좌 상 우 하
	static int[] dy = {0,-1,0,1};
	static int[] dx = {-1,0,1,0};
	static int dir = 2; //초기에 오른쪽으로 이동
//	dir = dir%4;
	static int N,K,L,X;
	static char C;
	static int[][] arr;
	
	static int time = 0;
	static int[] changeTime;
	static char[] changeDir;

	public static class Snake{
		int y, x;
		Snake(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static Queue<Snake> queue = new ArrayDeque<>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		//사과 표시
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			int y,x;
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			arr[y-1][x-1] = 9; //사과를 9로 표시
		}
		arr[0][0] = 1; //초기 좌상단부터 시작
		queue.offer(new Snake(0,0));
//		print();
		
		//방향 전환 입력
		L = Integer.parseInt(br.readLine());
		changeTime = new int[L];
		changeDir = new char[L];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			C = st.nextToken().charAt(0);
			
			changeTime[i] = X+1; //진행 한 뒤에 방향이 바뀌는 것이므로 다음 초(+1)에 변경되게 설정
			changeDir[i] = C;
		}
//		System.out.println("초기 상태 :");
//		print();
		play(0,0);
		System.out.println(time);
		
	}//main

	
	
	private static void play(int y, int x) {
		time+=1;
		//현재 플레이 시간과 방향전환 시간이 같은지 확인
		for(int i=0; i<changeDir.length;i++) {
			if(time==changeTime[i]) {
				if(changeDir[i] == 'L') { 
					dir-=1;
					if(dir<0) dir = 3;
				}else {
					dir+=1;
				}
				
				dir = dir % 4;
			}
		}//시간확인 끝

		int ny, nx;
		ny = y + dy[dir];
		nx = x + dx[dir];
		if(ny<0 || ny>=N || nx<0 || nx>=N) { //범위 밖이거나 자신의 몸에 부딪히면 게임 종료
			return;
		}else {//범위 내면 정상 진행
			queue.offer(new Snake(ny,nx));
			
			if(arr[ny][nx] == 9) { //사과먹으면 다음 재귀로
				if(arr[ny][nx] == 1) return;
				else {
					arr[ny][nx] = 1;
//					print();
					play(ny,nx);
				}
			}else if(arr[ny][nx]==0) { //사과 없으면 꼬리 줄이고 다음 재귀
				Snake tail = queue.poll();
				int tail_y = tail.y;
				int tail_x = tail.x;
				arr[tail_y][tail_x] = 0; //꼬리 먼저 자르고
				if(arr[ny][nx] == 1) return;
				else {
					arr[ny][nx] = 1; //머리 이동
//					print();
					play(ny,nx);
				}
				
			}
		}
		
	}//play

	private static void print() {
		System.out.println(time);
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}


























