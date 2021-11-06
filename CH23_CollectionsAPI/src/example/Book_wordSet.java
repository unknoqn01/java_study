package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Book_wordSet {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File worldsSherlock = new File("sherlock.txt");

		System.out.println(worldsSherlock.exists());

		TreeSet<String> sherlist = loadWords(worldsSherlock);

		System.out.println(sherlist.size());

		System.out.println(">");
		displayWords(sherlist);
	}

	private static void displayWords(TreeSet<String> sherlist) {
		//트리셋을 입력받아 그 안에 있는 단어들을 출력
		int count = 0;
		for( String w : sherlist) {
			if( w.length() >= 6) { 
			System.out.printf("%-10s \t", w);
			count ++;
			if( count == 6) {
				System.out.println();
				count = 0;
			}
			}
		}
	}

	private static TreeSet<String> loadWords(File file) throws FileNotFoundException, IOException {
		TreeSet<String> wordSet = new TreeSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = null;
			while ((line = br.readLine()) != null) { // 파일을 한줄씩 읽다가 마지막 글을 읽고나면 종료
				String[] words = line.split("[^a-zA-z]+");

				for (String w : words) {
					wordSet.add(w.toLowerCase());
				}
			}

		}

		return wordSet;
	}

}
