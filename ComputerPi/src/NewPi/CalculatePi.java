package NewPi;

public class CalculatePi implements Runnable{
	Thread runner ;
	private double n;
	private double sum;
	
	public CalculatePi(double n) {
		this.n = n;
		this.runner = new Thread(this);
		this.runner.start();
	}
	
	@Override
	public void run() {
		this.setSum( (4 * (Math.pow(-1, n + 1) / (2 * n - 1))));
	}
	

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public static void main(String[] args) throws InterruptedException {
		int n =10;
		double result = 0;
		for (int i = 1; i <= n; i++) {
			CalculatePi c = new CalculatePi(i);
			result+=c.sum;
		}
		System.out.println(result);
	}
}
