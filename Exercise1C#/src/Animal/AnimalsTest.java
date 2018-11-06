package Animal;
import java.util.LinkedList;
import java.util.List;

public class AnimalsTest {

	public static void averageAge(List<Animal> lists) {
		double sum = 0;
		String type = "";
		int count = 0;
		for (Animal animal : lists) {
			count++;
			sum += animal.getAge();
			type = animal.getType();
		}
		System.out.println("Average age of " + type + " is " + sum/count);
		System.out.println();
		System.out.println("------------------------------------------------- ");
	}

	public static void main(String[] args) {
		List<Animal> dogs = new LinkedList<Animal>();

		Animal pug = new Dog(26, "Pug", Gender.MALE);
		Animal aidi = new Dog(10, "Micky", Gender.FEMALE);
		Animal akita = new Dog(15, "Batty", Gender.FEMALE);
		Animal husky = new Dog(1, "Huky", Gender.MALE);
		Animal alopekis = new Dog(20, "Fast", Gender.MALE);
		Animal bullDog = new Dog(10, "Bull", Gender.FEMALE);
		Animal bullDog2 = new Dog(10, "Bull", Gender.MALE);
		Animal eskimo = new Dog(10, "Muc", Gender.FEMALE);
		Animal eskimo2 = new Dog(10, "Mouse", Gender.MALE);
		/*
		 * Add dogs to linkedlist
		 */
		dogs.add(pug);
		dogs.add(aidi);
		dogs.add(akita);
		dogs.add(husky);
		dogs.add(alopekis);
		dogs.add(bullDog);
		dogs.add(bullDog2);
		dogs.add(eskimo);
		dogs.add(eskimo2);
		// Frog
		List<Animal> frogs = new LinkedList<Animal>();

		Animal greenFrog = new Frog(1, "Green Dot", Gender.MALE);

		frogs.add(greenFrog);

		// Cats
		List<Animal> cats = new LinkedList<Animal>();

		Animal aegean = new Kitten(10, "Kitty");
		Animal asianSemiLonghair = new Kitten(5, "Mice");
		Animal asianSemiLonghair2 = new Kitten(2, "Kitty");
		Animal boombey = new Kitten(8, "Girl");
		Animal britishShorthair = new Kitten(2, "Meo");
		Animal britishLonghair = new Kitten(2, "Maow");
		Animal britishLonghair1 = new Kitten(2, "Santa");
		Animal americanBobtail = new Tomcat(5, "QS");
		Animal asianSemiLonghair3 = new Tomcat(5, "Lazy");
		Animal asianSemiLonghair4 = new Tomcat(5, "Fat");
		Animal britishLonghair2 = new Tomcat(5, "Rock");
		Animal britishLonghair3 = new Tomcat(5, "Red");
		Animal britishLonghair4 = new Tomcat(5, "Key");
		cats.add(aegean);
		cats.add(asianSemiLonghair);
		cats.add(asianSemiLonghair2);
		cats.add(boombey);
		cats.add(britishShorthair);
		cats.add(britishLonghair);
		cats.add(britishLonghair1);
		cats.add(americanBobtail);
		cats.add(asianSemiLonghair3);
		cats.add(asianSemiLonghair4);
		cats.add(britishLonghair2);
		cats.add(britishLonghair3);
		cats.add(britishLonghair4);

		for (Animal animal : cats) {
			System.out.println(animal );
		}
		averageAge(frogs);
		averageAge(dogs);
		averageAge(cats);
	}
}
