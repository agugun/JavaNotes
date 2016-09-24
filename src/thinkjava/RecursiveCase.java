package thinkjava;

public class RecursiveCase {

	public static int factorial_r(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial_r(n - 1);
		}
	}

	public static int fibonnaci_r(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return fibonnaci_r(n-1) + fibonnaci_r(n-2);
		}
	}

	public static void main(String[] args) {
		System.out.println(factorial_r(5));
	}
}
