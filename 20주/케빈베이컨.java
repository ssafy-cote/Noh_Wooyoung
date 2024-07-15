package cote_2phase22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1 3
 * 1 4
 * 2 3 
 * 3 4
 * 4 5
x x o o x 
x x o x x
o o x o x
o x o x o
x x x o x 

*/
public class 케빈베이컨 {
	static int N,M;
	static boolean[][] isFriend;
	static int A,B;
	static int[] result;
	static Queue<Node> queue = new ArrayDeque<>(); 
	static boolean[] know;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isFriend = new boolean[N][N];
		result = new int[N];
		
		
		for(int i=0; i<M; i++) {
			st  = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken()) - 1;
			B = Integer.parseInt(st.nextToken()) - 1;
			isFriend[A][B] = true;
			isFriend[B][A] = true;
		}
		
		//i는 현재 검사하는 사람(출발지)
		for(int i=0; i<N; i++) {
			//j는 현재 검사하는 사람이 바로 아는 사람
			int temp = 0;
			know = new boolean[N];
			know[i] = true;
			
			//바로 아는 사람은 큐에 넣음
			for(int j=0; j<N; j++) {
				if(isFriend[i][j]==true) {
					know[j] = true;
					queue.add(new Node(i,j,1));
				}
			}
			
			//큐에 뭐가 들어있으면 빼줌
			while(!queue.isEmpty()) {
				Node cur = queue.poll();
				int y = cur.y;
				int x = cur.x; //다음에 검사할 행 번호
				int dist = cur.dist;
				
				know[x] = true;
				temp += dist;
				
				//다음 행에 대해서 시작
				for(int k=0; k<N; k++) {
					if(isFriend[x][k] == true && know[k] == false) {
						know[k] = true;
						queue.add(new Node(x,k,dist+1));
					}
				}
			}
			
//			System.out.println(temp);
			result[i] = temp;
		}
		
		int ans=N+1;
		int minVal = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			if(result[i] < minVal) {
				minVal = result[i];
				ans = i;
			}
		}
		
		System.out.println(ans+1);
		
		
	}//main
	private static class Node{
		int y,x, dist;
		
		Node(int y, int x, int dist){
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
