package cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 서로 다른 L개 알파벳 소문자들로 구성, 최소 한개의 모음 + 최소 두 개의 자음
 * 알파벳이 증가하는 순서로 배열 -> abc(O), bac(X)
 * 사용했을 문자 종류 C가지 -> C개 문자들이 주어졌을 때 가능성 있는 암호들을 모두 구하라
 */

public class 암호만들기 {
	static int L,C;
	static char[] abc;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); //비밀번호 길이
		C = Integer.parseInt(st.nextToken()); //서로 다른 알파벳 개수

		abc = new char[C]; //알파벳 배열 생성
		isSelected = new boolean[C];

		//사용하는 문자 배열 생성
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			abc[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(abc); 
		//		System.out.println(Arrays.toString(abc));

		makeCode(0,0);
	}

	private static void makeCode(int cnt, int start) {
	    if(cnt == L) {
	        int c_num = 0; //선택된 알파벳 개수
	        int mom = 0; //모음, 자음
	        int son = 0;

	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<C; i++) {
	            if(isSelected[i]) {
	                sb.append(abc[i]);
	                c_num++;
	                if(abc[i]=='a' || abc[i]=='e' || abc[i]=='i' || abc[i]=='o' || abc[i]=='u') mom++;
	                else son++;
	            }
	        }

	        if(c_num==L && mom>=1 && son>=2) { //원하는 문자 길이만큼 나왔다면
	            System.out.println(sb);
	        }
	        return;
	    }

	    if (start >= C) // 배열의 범위를 벗어나면 종료
	        return;

	    isSelected[start] = true;
	    makeCode(cnt + 1, start + 1); //현재 문자 포함한 subset
	    isSelected[start] = false;
	    makeCode(cnt, start + 1); //현재 문자 포함하지 않은 subset 
	}


}
