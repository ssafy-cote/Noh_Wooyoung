package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 N개 도시, 일직선
 도로 길이는 N-1
 도시마다 주유소, 기름 가격 다름
 가격이 더 싸질때만 가격 변경
 
 메모리 31496kb
 시간 276ms
 */
public class 주유소 {
	static int total=0;
	static int[] road;
	static int[] cities;
	static int N,curPrice;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		road = new int[N-1];
		cities = new int[N];
		
		//도로 길이 
		for(int i=0; i<N-1; i++) {
			road[i] =  Integer.parseInt(st.nextToken());
		}

		//도시 별 가격
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}//마지막 가격은 사용안함

		curPrice = cities[0];

		for(int i=0; i<N-1; i++) {
			//만약 다음 도시의 가격이 더 싸다면 가격 바꿔준다
			if(cities[i]<curPrice) curPrice = cities[i];
			total += curPrice*road[i];
		}
		
		System.out.println(total);





	}

}
