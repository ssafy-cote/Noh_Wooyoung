package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
101길이의 1~100인덱스만 사용
bfs, +1~6의 주사위 굴려 나온 값을 큐에 추가
board의 인덱스는의 값은 다음 위치, 
isVisited 인덱스의 값은 몁 번 굴려서 나온 자리인지 표시하는 역할
 */
public class 뱀과사다리 {
	static int N,M; //사다리, 뱀의 수
	static int[] board = new int[101];
	static int[] isVisited = new int[101];
	static int curVal; //Y,X칸의 값
	static int result = 0;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//		isVisited[1] = 1; 

		N = Integer.parseInt(st.nextToken()); //사다리
		M = Integer.parseInt(st.nextToken()); //뱀

		for(int i=1; i<101; i++) {
			board[i] = i;
		}

		//사다리
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}

		//뱀
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			board[from] = to;
		}



		queue.offer(1);
		A: while(true) {
			int current = queue.poll();
			
			for(int i=1; i<=6; i++) {
				int next = current + i;
				if(next<101 && isVisited[board[next]]==0) {
					queue.offer(board[next]);
					isVisited[board[next]] = isVisited[current]+1;
				}
				
				if(board[next]==100) {
					result = isVisited[100];
					break A;
				}
			}
			
		}
		
		System.out.println(result);

	}//main












}
