package stream_example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File_Stream {

	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get("sherlock.txt")).forEach(System.out::println);
		
	}

}
