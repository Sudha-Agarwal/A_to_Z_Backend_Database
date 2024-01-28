package fileAPI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteStringExample {
	public static void main(String[] args) {
		Path filePath = Paths.get("src/main/resources/example.txt");
		
		try {
			String content ="\nHello from java11";
			
			StandardOpenOption options[] = {StandardOpenOption.APPEND, StandardOpenOption.CREATE};
			Files.writeString(filePath, content, options);
			System.out.println("File has been written");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
