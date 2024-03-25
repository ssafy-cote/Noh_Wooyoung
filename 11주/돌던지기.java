package temp;

import java.util.Scanner;

/*
 돌 N개
 상근 창영 상근 창영...
 1개나 3개만 가능, 2개 X
 
 한번씩 가져가면 반드시 짝수개 -> 반드시 후공이 이김
 
 
 */
public class 돌던지기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		if(N%2!=0) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}
	}

}
