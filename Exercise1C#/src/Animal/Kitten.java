package Animal;

public class Kitten extends Cat {
	static Gender sex = Gender.FEMALE;

	public Kitten(double age, String name) {
		super(age, name, sex);

	}

}
