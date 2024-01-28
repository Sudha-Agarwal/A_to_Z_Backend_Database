
public class StringAPIExample {
	public static void main(String[] args) {
		String str1 = "   ";
		
		System.out.println("Is blank: " + str1.isBlank());
		
		System.out.println("abc ".repeat(3));
		
		String str2 = "   Hello  World ";
		System.out.println(str2.stripTrailing());
		
		//lines()
		String str3 = "Line1\nLine2\nLine3";
		str2.lines().forEach(System.out::println);
		//:: method reference operator
		
		//or
		str2.lines().forEach(lines -> System.out.println(lines));
	}

}
