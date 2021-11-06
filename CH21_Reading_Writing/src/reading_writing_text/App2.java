package reading_writing_text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App2 {

	public static void main(String[] args) throws IOException {
		//파일의 절대경로를 문자열로 표시(\\로 표시됨)
		String fileLocation ="C:\\Users\\asdsd\\Desktop\\java_temp\\java_study\\CH21_Reading_Writing\\text.txt";
		System.out.println(new File(fileLocation).exists()); //파일이 있으면 true 없으면 false
	}

}
