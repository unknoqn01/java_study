package writing_lineByline.copy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		String fileLocation ="C:\\Users\\asdsd\\Desktop\\java_temp\\java_study\\CH21_Reading_Writing\\text.txt";
		System.out.println(new File(fileLocation).exists()); //파일이 있으면 true 없으면 false
		System.out.println();
			
		try(BufferedWriter br = new BufferedWriter(new FileWriter(fileLocation))) {
			br.write("오렌지\n");
			br.newLine();
			br.write("애플");
			br.newLine();
			br.write("바나나");
			br.write("배");
			
		} catch (IOException e) {
			System.out.println( "파일을 쓸 수가 없음 : " + fileLocation);
		}
		
		System.out.println("파일 쓰기 완료 : " + fileLocation);
	}
}
