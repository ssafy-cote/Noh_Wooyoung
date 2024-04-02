package temp;


/*
[사람 번호, 회차]로 정답 출력
끝까지 가면 [0,0]

이전 단어의 끝 알파벳 저장
현재 단어의 시작 알파벳과 다르면 종료

 */

import java.util.HashMap;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean flag = false; //마지막까지 갔는지
		char prev = words[0].charAt(0); //이전 단어의 마지막 알파벳
		int turn = 0; //나중에 출력할땐 +1해줘야됨, %n해서 사용
		int round = 1; //몇바퀴
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		int cnt = 0;
        
        for(String word: words) {
			cnt++;
			System.out.println(prev + " " + word);
			if(word.charAt(0)!=prev || hmap.containsKey(word)) {
				answer[0] = turn+1;
				answer[1] = round;
				break;
			}else {
				hmap.put(word, 0);
				prev = word.charAt(word.length()-1);
			}
			
			
			if(cnt==words.length) flag = true; 
			turn++;
			round += turn/n;
			turn = turn % n;
		
			System.out.println(flag);
		}
		
		if(flag) {
			answer[0] = 0;
			answer[1] = 0;
		}
        
        return answer;
    }
}

//public class 영어끝말잇기 {
//
//	public static void main(String[] args) {
//		int n = 2;
//		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
//		int[] answer = new int[2];
//		boolean flag = false; //마지막까지 갔는지
//		char prev = words[0].charAt(0); //이전 단어의 마지막 알파벳
//		int turn = 0; //나중에 출력할땐 +1해줘야됨, %n해서 사용
//		int round = 1; //몇바퀴
//		
//		
//		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
//		int cnt = 0;
//		
//		for(String word: words) {
//			cnt++;
//			System.out.println(prev + " " + word);
//			if(word.charAt(0)!=prev || hmap.containsKey(word)) {
//				answer[0] = turn+1;
//				answer[1] = round;
//				break;
//			}else {
//				hmap.put(word, 0);
//				prev = word.charAt(word.length()-1);
//			}
//			
//			
//			if(cnt==words.length) flag = true; 
//			turn++;
//			round += turn/n;
//			turn = turn % n;
//		
//			System.out.println(flag);
//		}
//		
//		if(flag) {
//			answer[0] = 0;
//			answer[1] = 0;
//		}
//		
//		System.out.println(answer[0] + " " + answer[1]);
//	}
//}


