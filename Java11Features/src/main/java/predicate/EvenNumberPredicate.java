package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EvenNumberPredicate {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> isEven = number-> number%2 == 0;
		
		Predicate<Integer> isOdd = Predicate.not(isEven);
		
		//use a stream to filter out even numbers
		List<Integer> evenNumbers = numbers.stream()
							.filter(isOdd)
							.collect(Collectors.toList());
		
		System.out.println(evenNumbers);
		
	}

}
