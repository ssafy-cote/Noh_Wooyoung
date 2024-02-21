package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 이차원배열 돌면서 0이 아닌 인덱스가 나오면 cnt+1하고 bfs
 bfs하면서 연결된 칸들은 다 0으로 설정
 
 */
public class 트리 {
	static int n,m; //정점 개수, 간선 개수
	static int from, to;
	static int[][] arr;
	static int cnt;
	static Queue<Integer> queue = new ArrayDeque<Integer>();
	static int tc =0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tc += 1;
			cnt = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
//			System.out.println("정점:"+n+" 간선:"+m);
			if(n==0 && m==0) break;
			
			//간선 있는거 표시
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken())-1; //인덱스로 사용할 것이므로 -1
				to = Integer.parseInt(st.nextToken())-1;
				arr[from][to] = 1;
				arr[to][from] = 1;	
			}
			
			for(int i=0; i<n; i++) {
				arr[i][i] = 1;
//				System.out.println(Arrays.toString(arr[i]));
			}
			
			//모든 인덱스 찾아가면서 1인것 탐색
			//1 찾았으면 cnt+1하고 그 인덱스를 시작점으로 하여 bfs, 연결된 인덱스들 모두 0으로 설정 
			// -> 연결된 인덱스가 모두 0이므로 연결되지 않은(다른 트리) 것이 1이됨.
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					
					if(arr[y][x] == 1) {
						cnt++;
						arr[y][x] = 0;
						arr[x][y] = 0;
						queue.offer(x);
						while(!queue.isEmpty()) {
							int current = queue.poll();
							for(int col=0; col<n; col++) { //현재 행에서 값이 1인것들 있으면 연결된 노드이므로 큐에 넣어준다
								if(arr[current][col] == 1) {
									arr[current][col] = 0;
									arr[col][current] = 0;
									queue.offer(col);
								}
									
							}
						}
					}
				}
			}
			
			if(cnt == 0) {
				System.out.println("Case "+tc+": No trees.");
			}else if(cnt == 1) {
				System.out.println("Case "+tc+": There is one tree.");
			}else {
				System.out.println("Case "+tc+": A forest of "+cnt+" trees.");
			}
		}//while
	}//main
	

}