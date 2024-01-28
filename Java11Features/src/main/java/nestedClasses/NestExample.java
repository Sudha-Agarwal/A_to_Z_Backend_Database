package nestedClasses;

public class NestExample {
	private static int sharedPrivateStaticField = 20;
	
	public static void main(String[] args) {
		OuterClass outerInstance = new OuterClass();
		
		//accessing the private members of the same nest
		System.out.println(sharedPrivateStaticField);
		System.out.println(outerInstance.getInnerInstance().getPrivateInstanceField());
		
		
		
	}
	
	private static class OuterClass{
		
		private static class InnerClass{
			private int privateInstanceField = 99;
			
			private int getPrivateInstanceField() {
				return privateInstanceField;
			}
			
			
		}
		public InnerClass getInnerInstance() {
			return new InnerClass();
		}
	}

}
