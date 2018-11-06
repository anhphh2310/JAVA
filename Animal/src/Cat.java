public class Cat extends Animal {

	public Cat(double age, String name, Gender sex) {
		super(age, name, sex);
	}

	@Override
	public void produceSound() {
		System.out.println("Cat sounds :Meow Meow...");
	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return "Cat";
	}

}
