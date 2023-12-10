import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreesSetExample {
	public static void main(String[] args) {
		Set<String> treeSet = new TreeSet<String>(Comparator.reverseOrder());
		
		treeSet.add("Banana");
		treeSet.add("Apple");
		treeSet.add("Apples");
		treeSet.add("Mango");
		treeSet.add("Grapes");
		
		System.out.println(treeSet);
	}

}
