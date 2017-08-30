import java.util.Scanner;

public class Main {
	static long x0, y0;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long x = scan.nextInt();
		long y = scan.nextInt();
		long m = scan.nextInt();
		long n = scan.nextInt();
		long L = scan.nextInt();
		x %= L;
		y %= L;
		long a = m - n;
		long b = -L;
		if((y - x) % gcd(a, b) != 0){
			System.out.println("Impossible");
			return;
		}
		gcdEx(a, b);
		long A = b/gcd(a, b);
		long B = x0 * (y - x)/gcd(a, b);
		long ans = (B%A + A)%A;
		System.out.println(ans == 0 ? A : ans);
	}

	public static long gcd(long a, long b){
		return b == 0 ? a : gcd(b, a%b);
	}

	public static long gcdEx(long a, long b){
		if(b == 0){
			x0 = 1;
			y0 = 0;
			return a;
		}
		else{
			long r = gcdEx(b, a%b);
			long t = x0;
			x0 = y0;
			y0 = t - a/b * y0;
			return r;
		}
	}
}
