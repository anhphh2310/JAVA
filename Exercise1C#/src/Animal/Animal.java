package Animal;
public abstract class Animal implements ISound {

	private double age;
	private String name;
	private Gender sex;

	public Animal() {

	}

	public Animal(double age, String name, Gender sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", sex=" + sex + "]";
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	abstract String getType();

}
