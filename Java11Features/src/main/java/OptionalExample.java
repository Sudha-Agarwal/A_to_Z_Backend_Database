import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		String[] str = new String[10];
		//String lowerCase = str[0].toLowerCase();
		
		//System.out.println(lowerCase);
		
		//with optional
		str[0] = "hello";
		Optional<String> checkNull = Optional.ofNullable(str[0]);
		
		if(str[0] != null) {
			System.out.println("not null");
		}
		
		if(checkNull.isPresent()) {
			System.out.println(str[0].toUpperCase());
		}
		else {
			System.out.println("string value is not present");
		}
		
		Optional<String> optionalValue = Optional.of("Hello");
		
		Optional<String> filterdVal = optionalValue.filter(s->s.length() > 5);
		
		System.out.println(filterdVal.isEmpty());
		System.out.println(filterdVal.isPresent());
	}

} 
