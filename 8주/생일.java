package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 생일 {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());

	        List<Student> students = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            String name = st.nextToken();
	            int day = Integer.parseInt(st.nextToken());
	            int month = Integer.parseInt(st.nextToken());
	            int year = Integer.parseInt(st.nextToken());
	            students.add(new Student(name, day, month, year));
	        }

	        Collections.sort(students);

	        System.out.println(students.get(students.size() - 1).name);
	        System.out.println(students.get(0).name);
		
	}
	static class Student implements Comparable<Student>{
		String name;
		int year,month,day;
		
		Student(String name, int day, int month, int year){
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Student o) {
			//연,월,일 순으로 빼서 비교하고 this가 더 크면 양수, 작다면 음수 반환 
		    if (this.year != o.year)
		        return this.year - o.year;
		    if (this.month != o.month)
		        return this.month - o.month;

		    return this.day - o.day;
		}
		
	}

}
