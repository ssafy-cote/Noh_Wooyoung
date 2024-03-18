package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 걸그룹 개인과 팅믜 이름 검색해서 외우게 하는 퀴즈 프로그램
 입력받을 걸그룹 수 N, 맞혀야 할 문제수 M <100
 
 팀이름
 그룹 인원수
 멤버
 멤버
 멤버...
 
 다른 그룹에 이름 같은 멤버 X
 
 M개퀴즈 각각 2줄
 팀이나 멤버 이름
 퀴즈 종류 0(팀이름) 1(멤버이름
 
 0이면 해당 팀에 속한 멤버이름 사전순으로 출력
 1이면 멤버가 속한 팀의 이름 출력
 
 */
public class 걸그룹마스터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken()); //그룹 수
		int M = Integer.parseInt(st.nextToken()); //문제 수
		
		ArrayList<String>[] girlGroups = new ArrayList[N]; //리스트 배열
		
		//그룹 N개 만들기
		for(int i=0; i<N; i++) {
			girlGroups[i] = new ArrayList<String>();
			
			String teamName = br.readLine();
			girlGroups[i].add(teamName);
			
			//그룹원들 큐에 넣기
			int numOfGroup = Integer.parseInt(br.readLine());
			for(int j=0; j<numOfGroup; j++) {
				girlGroups[i].add(br.readLine());
			}
			
		}
		
		//멤버 이름 정렬
		for (int i = 0; i < N; i++) {
                Collections.sort(girlGroups[i].subList(1, girlGroups[i].size()));
        }
				
		//퀴즈쇼 시작
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			int quiz = Integer.parseInt(br.readLine());
			if (quiz == 0) { // 팀이름
			    for (int j = 0; j < N; j++) {
			        if (girlGroups[j].get(0).equals(name)) {
			            for (int k = 1; k < girlGroups[j].size(); k++) {
			                System.out.println(girlGroups[j].get(k));
			            }
			            break;
			        }
			    }
			} else { // 멤버이름
			    for (int j = 0; j < N; j++) {
			        for (int k = 1; k < girlGroups[j].size(); k++) {
			            if (girlGroups[j].get(k).equals(name)) {
			                System.out.println(girlGroups[j].get(0));
			                break;
			            }
			        }
			    }
			}
		}
		
	}

}
