
public class ThreadN1 extends Thread {
	private double sum;
	private double sumTh;
	private transient Thread thread;
	public ThreadN1(Thread thread) {
		// TODO Auto-generated constructor stub
		this.thread = thread;

	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (thread == null) {
				continue;
			}else {
					sumTh += sum;
					setThread(null);
					continue;
			}
			
	}	
	}
	
	public double getSumTh() {
		return sumTh;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}
