package PiCal;

public class CalculatePi extends Thread {
	private double n;
	private double sum;
	
	public CalculatePi(double n) {
		this.n = n;
	}

	@Override
	public void run() {
		this.setSum((4 * (Math.pow(-1, n + 1) / (2 * n - 1))));

	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public static void main(String[] args) throws InterruptedException {
		int n = 10;
		CalculatePi list[] = new CalculatePi[n];
		for (int i = 1; i < list.length; i++) {
			CalculatePi calPi = new CalculatePi(i);
			list[i] = calPi;
		}
		//ThreadLast last = new ThreadLast(n);
		ThreadLast last = new ThreadLast(0);
		last.start();
		double sum = 0;
		for (int i = 1; i < list.length; i++) {
			list[i].start();
			//list[i].join();
			//sum+=list[i].sum;
			//last.setSum(sum);
			last.receive(list[i].sum);
			//last.setSum(list[i].sum);
			
		}
		last.terminate();
	}
}
