package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 인접리스트로 각 인덱스를 시작점으로 사용하고 방문한 적이 없을 때만 +1
 * 118828kb 472ms
 */
public class 연결요소의개수 {
	static int N,M;
	static int[][] arr;
	static int cnt = 0; 
	static Queue<Integer> queue =  new ArrayDeque<Integer>();
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt( st.nextToken());
		M = Integer.parseInt( st.nextToken());
		
		arr = new int[N][N];
		isVisited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		//bfs
		for(int i=0; i<N; i++) { //인덱스를 모두 시작점으로 해서 bfs검사
			if(isVisited[i] == false) {
//				System.out.println(i);
				queue.offer(i);
				cnt++;
				
				while(!queue.isEmpty()) {
					int current = queue.poll();
					for(int j=0; j<N; j++) {
						if(arr[current][j] == 1 && isVisited[j]==false) {
							queue.offer(j);
							isVisited[j] = true;
						}
					}
				}
			}
			
		}
		
//		for(int i=0; i<N; i++) { //인덱스를 모두 시작점으로 해서 bfs검사
//			if(isVisited[i] == false) {
//				queue.offer(i);
//				cnt++;
//			}
//			int current = queue.poll();
//			for(int j=0; j<N; j++) {
//				if(arr[i][j] == 1) {
//					queue.offer(j);
//					isVisited[j] = true;
//				}
//			}
//		}
		System.out.println(cnt);
		
	}

}