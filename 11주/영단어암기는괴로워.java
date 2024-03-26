package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 맵에 단어:등장횟수로 저장 -> 같은단어 중복 없애줌
 하나씩 꺼내서 리스트에 저장
 comparable로 정렬
 */


public class 영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer>  wordCnt = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() >= M) {
				wordCnt.put(word,  wordCnt.getOrDefault(word, 0) + 1); //없던거면 넣고 0으로, 있던거면 +1
			}
		}

		List<Word> wordList = new ArrayList<>();
		//모든 키값 쌍 
		for (Map.Entry<String, Integer> entry :  wordCnt.entrySet()) {
			wordList.add(new Word(entry.getKey(), entry.getValue()));
		}

		Collections.sort(wordList);

		//		for (Word word : wordList) {
		//			System.out.println(word.word);
		//		}

		StringBuilder sb = new StringBuilder();
		for (Word word : wordList) {
			sb.append(word.word).append('\n');
		}

		System.out.print(sb);

	}
	private static class Word implements Comparable<Word> {
		String word;
		int times;

		public Word(String word, int frequency) {
			this.word = word;
			this.times = frequency;
		}

		@Override
		public int compareTo(Word o) {
			//등장횟수, 길이, 사전순
			if (this.times != o.times) {
				return Integer.compare(o.times, this.times); 
			} else if (this.word.length() != o.word.length()) {
				return Integer.compare(o.word.length(), this.word.length()); 
			} else {
				return this.word.compareTo(o.word); 
			}
		}
	}
}
