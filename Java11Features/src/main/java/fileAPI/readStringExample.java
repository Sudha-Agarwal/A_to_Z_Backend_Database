package fileAPI;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readStringExample {
	public static void main(String[] args) {
		Path filePath = Paths.get("src/main/resources/example.txt");
		
		Charset charset = Charset.forName("UTF-8");
		
		try {
			String content = Files.readString(filePath,charset);
			
			//or
			String content1 = Files.readString(filePath);
			
			System.out.println(content);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
