public class Dog extends Animal {

	public Dog(double age, String name, Gender sex) {
		super(age, name, sex);
	}

	@Override
	public void produceSound() {
		System.out.println("Dog bark: Woof Woof...");
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Dog";
	}

}
