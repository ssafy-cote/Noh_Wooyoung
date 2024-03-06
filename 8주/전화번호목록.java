package temp;


import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        if(phone_book.length==1) return true;
        
        A:for(int i=0; i<phone_book.length-1; i++) {
			for(int j=i+1; j<phone_book.length;j++) {
				if(phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
        
        
        return true;
    }
}