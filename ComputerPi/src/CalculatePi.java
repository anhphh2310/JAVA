import java.util.Scanner;

public class CalculatePi extends Thread {
	private double pi;
	private double sum;
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public CalculatePi(double pi) {
		super();
		this.pi = pi;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		double n = this.pi;
		this.pi = (4 * (Math.pow(-1, n + 1) / (2 * n - 1)));
	}
			

	public static void main(String[] args) throws InterruptedException {
//		int n = 0;
//		n = 100;
//		// CalculatePi last = new CalculatePi(n+1);\
//		ThreadN1 th = new ThreadN1(null);
//		th.start();
//		double pi=0;
//		for (int i = 1; i <= n; i++) {
//			CalculatePi t = new CalculatePi(i);
//			synchronized (t) {
//				t.start();
//				t.wait();
//				th.setSum(t.pi);
//				th.setThread(t);
//			}
//
//		}
//		
//		System.out.println(th.getSumTh());

		// ---------------------------------------//
		int n = 0;
		Scanner input = new Scanner(System.in);
		n = Integer.parseInt(input.nextLine());
		CalculatePi last = new CalculatePi(n+1);
		last.start();
		System.out.println(last.isAlive());
		for (int i = 1; i <= n; i++) {
			CalculatePi t = new CalculatePi(i);
			t.start();
			System.out.println("t"+t.pi);
			/*t.join();
			 			pi +=t.getPi();*/
			last.join();
		}
	}

	private int getInput() {

		int end = 0;

		Scanner input = new Scanner(System.in);

		System.out.println("How many calculations should be run for the approximation?");

		try {

			end = Integer.parseInt(input.nextLine());

		} /** Handle input greater than Java's MAX_INT. **/

		catch (NumberFormatException e) {

			System.out.println("n is too large. Setting n to be the largest possible int value.");

			end = Integer.MAX_VALUE;

		}

		input.close();

		return end;

	}

	public double getPi() {
		return pi;
	}

	public void setPi(double pi) {
		this.pi = pi;
	}

}
