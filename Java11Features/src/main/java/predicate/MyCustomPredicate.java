package predicate;

import java.util.function.Predicate;

public class MyCustomPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {		
		return t>=18 && t<25;
		
	}

	
	public static void main(String[] args) {
		MyCustomPredicate customPredicate = new MyCustomPredicate();
		System.out.println(customPredicate.test(19));
		
		Predicate<Integer> obj =  

			
			(String t)-> {
				
				return false;
			};
			
		
		System.out.println(obj.test(20));
		
		Predicate<Integer> obj1 = new Predicate<>() {

			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		
		Predicate<Integer> LessThan45 = x-> x < 45;
		System.out.println(LessThan45.test(90));
		

	}
}


