package reading_writing_text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

	public static void main(String[] args) throws IOException {
		// 텍스트 파일 읽고 쓰기
//		File currentDirectory = new File(".");
//		
//		for(String f : currentDirectory.list()) {
//			System.out.println(f);
//		}
		
		// 텍스트 파일 쓰기
		String text = "헬로우! \n 하 와 유 ?";
		
		Path path = Paths.get("text.txt");
		Files.write(path,  text.getBytes()); //files.write(파일주소 ,적을내용)
		
		// 파일 읽기
		String recivedText = Files.readString(path);
		System.out.println(recivedText);
	}

}
