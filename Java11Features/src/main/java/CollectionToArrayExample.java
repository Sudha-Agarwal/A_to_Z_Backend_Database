import java.util.Arrays;
import java.util.List;

public class CollectionToArrayExample {
	public static void main(String[] args) {
		//create a list of strings
		List<String> list = Arrays.asList("Apple","Banana", "Orange");
		
		
		String[] stringArray = list.toArray(new String[0]);
		//or
		String[] stringArray1 = list.toArray(String[]::new);
		
		
	}

}
