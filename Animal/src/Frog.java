public class Frog extends Animal {

	public Frog(double age, String name, Gender sex) {
		super(age, name, sex);
	}

	@Override
	public void produceSound() {
		System.out.println("Fog sounds : Kwak Kwak...");

	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Frog";
	}
}
