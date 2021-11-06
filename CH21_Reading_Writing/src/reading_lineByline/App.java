package reading_lineByline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		String fileLocation ="C:\\Users\\asdsd\\Desktop\\java_temp\\java_study\\CH21_Reading_Writing\\text.txt";
		System.out.println(new File(fileLocation).exists()); //파일이 있으면 true 없으면 false
		System.out.println();
		
		//파일을 한줄씩 읽을수 있는 클래스
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileLocation))) {
		
		String line = null;
		while((line = reader.readLine()) != null ) { //파일을 한줄씩 읽다가 마지막 글을 읽고나면 종료
			System.out.println(line);
		}
		
		} catch(FileNotFoundException e) {
			// 파일이ㅣ 파일주소에 없을떄
			System.out.println("파일을 찾지 못함 : " + fileLocation);
		} catch (IOException e) {
			//파일을 읽지 못함
			System.out.println("파일을 읽지 못함 : " + fileLocation);
		} 
	
	}

}
