package HrManagement;

public class Worker extends Human implements Comparable<Worker>{

	private double weekSalary;
	private int workHoursPerDay;
	
	public Worker(String firstNameWk, String lastNameWk,double weekSalary,int workHoursPerDay) {
		firstName = firstNameWk;
		lastName = lastNameWk;
		this.weekSalary = weekSalary;
		this.workHoursPerDay = workHoursPerDay;				
	}

	
	public double getWeekSalary() {
		return weekSalary;
	}


	public void setWeekSalary(double weekSalary) {
		if(weekSalary<0) {
			System.out.println("Khong thoa dieu kien!");
		}
		else {
			this.weekSalary = weekSalary;
		}
	}


	public int getWorkHoursPerDay() {
		return workHoursPerDay;
	}


	public void setWorkHoursPerDay(int workHoursPerDay) {
		if(workHoursPerDay<=0 || workHoursPerDay>=24) {
			System.out.println("Khong thoa dieu kien!");
		}
		else {
			this.workHoursPerDay = workHoursPerDay;
		}
	}


	public double moneyPerHour() {
		return weekSalary/(workHoursPerDay*5);
	}


	@Override
	public int compareTo(Worker o) {
		if(this.moneyPerHour() > o.moneyPerHour()) {
			return -1;
		}
		if(this.moneyPerHour() < o.moneyPerHour()) {
			return 1;
		}
		return 0;
	}


	@Override
	public String toString() {
		return "Worker [firstName=" + firstName + ", lastName=" + lastName + ", moneyPerHour()=" + moneyPerHour() + "]";
	}


		
}
