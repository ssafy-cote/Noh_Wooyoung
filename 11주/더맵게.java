package temp;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
 가장 안매운거 2개 합쳐서 1개로
 합치면 길이 -1
 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 모두 k 이상이면 종료

 정렬->합치기->조건확인->만족안했으면 다시
 길이 1이고 K미만이면 -1리턴

 배열로 하니까 시간초과 정렬 생성 등 시간 오래먹음
 -> 우선순위큐 사용
 두개 빼서 합쳐서 넣고 반복
 맨 앞의 값이 k이상이면 종료
 길이 1인데 k미만이면 -1

 테케 18만 틀리는데 왜인지를 모르겠음
 */


class Solution {
	public int solution(int[] scoville, int K) {
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		int cnt = 0;

		while(pq.size() > 1) {
			cnt += 1;

			int first = pq.poll();
			int second = pq.poll();
			pq.offer(first + second * 2);

			if(pq.peek() >= K) {
				ans = cnt;
				break;
			}
		}

		if(pq.size() == 1 && pq.peek() < K) {
			ans = -1;
		}

		return ans;
	}
}

