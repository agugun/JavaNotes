package scjp;

public class Chapter1 {
	
	static void test(int i) {
		System.out.println(i);
	}
	
	private String instVar1; 
	
	private ClassA a = new ClassA(){
		
	};
	
	public class ChapterInner {
		public void test2 () {
			System.out.println(instVar1);
		}
	}
	
	public static void main(String[] args) {
		
		Chapter1 ch = new Chapter1();
		Chapter1.ChapterInner ch2 = ch.new ChapterInner();
		
		Test itf = new Test() {
			
		};
		
		ClassA a = new ClassA();
		ClassA b = new ClassB();
		
		a.printTest();
		b.printTest();
		
		String a1 = "Test001";
		String b2 = "Test001";
		
		Integer i1 = 0;
		
		Integer i=2;
		
		test(i);
		
		System.out.println(a ==b);
	}
}
