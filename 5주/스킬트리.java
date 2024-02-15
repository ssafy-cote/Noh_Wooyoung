package string;

import java.util.Arrays;

/*
 *스킬트리와 같은 길이의 int배열 생성
 *반복문으로 현재 스킬 처리하면서 스킬트리의 문자가 나오면 몇번째에 나왔는지 등록
 *int배열 앞에서부터 처리하면서 뒤 인덱스의 값이 더 크게 끝나면 +1
 *
테스트 1 〉	통과 (0.04ms, 68.1MB)
테스트 2 〉	통과 (0.04ms, 75.2MB)
테스트 3 〉	통과 (0.04ms, 67.7MB)
테스트 4 〉	통과 (0.04ms, 71.5MB)
테스트 5 〉	통과 (0.06ms, 74.1MB)
테스트 6 〉	통과 (0.07ms, 77.9MB)
테스트 7 〉	통과 (0.04ms, 74.8MB)
테스트 8 〉	통과 (0.05ms, 75MB)
테스트 9 〉	통과 (0.05ms, 76.5MB)
테스트 10 〉	통과 (0.07ms, 74.5MB)
테스트 11 〉	통과 (0.07ms, 93.8MB)
테스트 12 〉	통과 (0.19ms, 77MB)
테스트 13 〉	통과 (0.07ms, 74.2MB)
테스트 14 〉	통과 (0.05ms, 75.7MB)
 */


class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result=0;
        for(String current : skill_trees) {  
			boolean flag = true;
			char[] order = skill.toCharArray(); //1~26
			char[] curArr = current.toCharArray(); //현재 스킬 문자열을 배열로 만듦
			int[] temp = new int[order.length];
			
			for(int i=0; i<temp.length; i++) {
				temp[i] = 27;
			}
			
			for(int i=0; i<curArr.length; i++) {
				for(int j=0; j<order.length; j++) { //스킬트리의 스킬(알파벳)을 하나씩 체크
					if(curArr[i]==order[j]) temp[j] = i; //스킬트리에 있는 스킬이 현재 체크하는 스킬에 있으면 인덱스 저장
				}
			}
			
			for(int i=1; i<temp.length; i++) {
				if(temp[i]<temp[i-1]) flag = false;
			}
			if(flag) result++;
			
		}
        return result;
    }
}

//public class 스킬트리 {
//
//	public static void main(String[] args) {
//		String skill = "CBD";
//		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
//		int result=0;
//		
//		
//		//입력으로 들어온 스킬 배열에서 하나씩 빼서 검사
//		for(String current : skill_trees) {  
//			boolean flag = true;
//			char[] order = skill.toCharArray(); //1~26
//			char[] curArr = current.toCharArray(); //현재 스킬 문자열을 배열로 만듦
//			int[] temp = new int[order.length];
//			
//			for(int i=0; i<temp.length; i++) {
//				temp[i] = 27; //최대 길이가 26이므로 나올 수 없는 값인 27로 초기화
//			}
//			
//			for(int i=0; i<curArr.length; i++) {
//				for(int j=0; j<order.length; j++) { //스킬트리의 스킬(알파벳)을 하나씩 체크
//					if(curArr[i]==order[j]) temp[j] = i; //스킬트리에 있는 스킬이 현재 체크하는 스킬에 있으면 인덱스 저장
//				}
//			}
//			System.out.println(Arrays.toString(temp));
//			for(int i=1; i<temp.length; i++) {
//				if(temp[i]<temp[i-1]) flag = false;
//			}
//			if(flag) result++;
//			
//		}
//	System.out.println(result);
//	}//main
//}

