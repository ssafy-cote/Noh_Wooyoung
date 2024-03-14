package temp;

import java.util.Arrays;

/*
 *  2 -> 0010 
 *  3 -> 0011 비트 차이 1개, 2보다 크면서 가장 작은 숫자이므로 정답
 * 
 * numbers배열의 숫자들 하나씩 꺼냄
 * 변수 a를 현재 숫자의 2진수변환한거로 저장
 * b에는 a 1씩 증가시키면서 2진수 변환, a이진수랑 비교, 비트 차이가 2개 이하면 종료 -> 안됨
 * 
 * <2트>
 * 짝수는 +1이 정답
 * 홀수
 * 1) 0이 없는 홀수
 * +1하면 길이 늘어남
 * 길이 늘리고 두번째 자리에 0넣은게 정답
 * 
 * 2) 0 있는 홀수
 * 마지막 0을 1로 바꾸고 다음 1을 0으로 바꿔 해결
 * 
 * substring()
 * 종류 2개, 인자 하나만 받으면 그 위치부터 이후의 문자열 리턴
 * 인자 2개면 시작인덱스, 끝인덱스
 * 
 */
public class 비트2개 {

	public static void main(String[] args) {
		long[] numbers = {2,7};
		long[] answer = new long[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			long current = numbers[i];
			if(current%2==0) { //짝수면 +1이 정답
				answer[i] = current+1;
			}
			else { //홀수
				StringBuilder sb = new StringBuilder();
				String A = Long.toBinaryString(current);
				if(A.contains("0")) { //0이 하나라도 있으면 
					int lastZero = A.lastIndexOf("0");
					int firstOneAfterZero = A.indexOf("1",lastZero); //마지막 0 다음에 나오는 첫번쨰 1 자리
					
					sb.append(A,0,lastZero).append("1");
					
					sb.append("0");
					
					sb.append(A.substring(firstOneAfterZero+1));
					
				}else { //1로만 구성됐으면
					//두번쨰 자리에 0넣고 나머지는 다 1로
					sb.append("10").append(A.substring(1).replace("0", "1"));
				}
				answer[i] = Long.parseLong(sb.toString(),2);
			}
			
		}
		System.out.println(Arrays.toString(answer));
	}
}
