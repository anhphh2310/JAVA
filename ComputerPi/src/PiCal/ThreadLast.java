package PiCal;

public class ThreadLast extends Thread {

	public  double sum;
	public  double result = 0;
	private volatile boolean running = true;
	

	public ThreadLast(double sum) {
		this.sum = sum;
	}

	public void terminate() {
		running = false;
	}
	@Override
	public void run() {
		while (running) {
			//System.out.println("Thread n+1 is running!");
			//setResult(getResult() + sum);
		}
	//	setResult(getResult()+(4 * (Math.pow(-1, sum + 1) / (2 * sum - 1))));
		System.out.println(result);
	}

	/*@Override
	public void run() {
		while (running) {
			//System.out.println("Thread n+1 is running!");
		}
		setResult(getResult()+(4 * (Math.pow(-1, sum + 1) / (2 * sum - 1))));
		System.out.println(result);
	}*/

	public  double getResult() {
		return result;
	}

	public  void setResult(double result) {
		this.result = result;
	}

	public void receive(double moreSum) {
		this.setResult(moreSum + this.getResult());
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

}
