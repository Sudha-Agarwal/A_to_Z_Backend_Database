package nestedClasses;

public class NonStaticInnerClass {
	private int outervariable;
	private static int staticOuterVar;
	
	class Inner{
		void innerMethod() {
			outervariable = 10;
			System.out.println(outervariable);
		}
	}
	
	static class staticNested{
		void nestedMethod() {
			staticOuterVar = 20;
			System.out.println(staticOuterVar);
		}
		
	}
	
	public static void main(String[] args) {
		NonStaticInnerClass outerInstance = new NonStaticInnerClass();
		//creating an instance of non static inner class
		Inner innerInstance = outerInstance.new Inner();
		innerInstance.innerMethod();
		
		//creating object of static inner class
		staticNested staticInnerInstance = new NonStaticInnerClass.staticNested();
		staticInnerInstance.nestedMethod();
	}

}
