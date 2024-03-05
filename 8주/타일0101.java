package temp;

import java.util.Arrays;
import java.util.Scanner;

/*
 
1
A

2 - 2
AA
BB +

3 - 3
AAA
BBA
ABB +

4 - 5
AAAA
BBAA
ABBA
AABB + 
BBBB +

5 - 8
AAAAA
BBAAA
ABBAA
AABBA
AAABB +
BBBBA 
ABBBB +
BBABB + 

6 - 13
AAAAAA
BBAAAA
ABBAAA
AABBAA
AAABBA
AAAABB + 
BBBBAA
ABBBBA
AABBBB +
BBAABB + 
ABBABB +
BBABBA +
BBBBBB +


7 - 19
AAAAAAA
BBAAAAAA
ABBAAAA
AABBAAA
AAABBAA
AAAABBA
AAAAABB

BBBBAAA
ABBBBAA
AABBBBA
AAABBBB

BBAAABB -
ABBAABB -
AABBABB -
BBAABBA -
BBABBAA -
BBBBBBA 
BBBBABB
BBABBBB
ABBBBBB
BBBBBBB

결과 피보나치수열나옴
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
