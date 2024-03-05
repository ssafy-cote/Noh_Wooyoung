package temp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 00 , 1
 * 2의 배수 되면 
 */

public class 타일0101 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] arr = new int[N+1]; //인덱스 == 길이
		
		if(N==1)System.out.println(1);
		else if(N==2)System.out.println(2);
		else {
			arr[1] = 1;
			arr[2] = 2;
			for(int i=3; i<=N; i++) {
				arr[i] = (arr[i-1] + arr[i-2])%15746;
			}
			
//			System.out.println(Arrays.toString(arr));
			
			System.out.println(arr[N]);
		}
		
		
		
	}

}
