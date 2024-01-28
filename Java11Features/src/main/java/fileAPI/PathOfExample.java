package fileAPI;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class PathOfExample {
	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		//create a path using path.of method
		
		Path path = Path.of("parent", "child1","child2","child3");
		System.out.println("path:" + path);
		
		URL url = new URL("file://path//to//file.txt");
		URI uri = url.toURI();
		Path path1 = Path.of(uri);
		
		System.out.println("URI path: " + path1);
		
		
	}

}
