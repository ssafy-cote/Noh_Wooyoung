package temp;

import java.util.Arrays;
class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        
       int[] counts = new int[tangerine.length];
        for(int i=0; i<tangerine.length; i++) {
			counts[tangerine[i]-1]++;
		}
        Arrays.sort(counts);
        int sum=0;
		int cnt=0;
		for(int i=counts.length-1; i>=0; i--) {
			cnt++;
			sum+=counts[i];
			if(sum>=k) break;
		}
        return cnt;
    }
}