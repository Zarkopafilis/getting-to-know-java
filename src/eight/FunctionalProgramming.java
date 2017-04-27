package eight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class FunctionalProgramming {

	public static void main(String[] args) {

		Function<Integer, Integer> twice = x -> x * 2;
		out.println("twice(2):  " + twice.apply(2));

		Function<String, String> mister = x -> "Mr. " + x;
		out.println(mister.apply("Zarkopafilis"));

		Function<Person, String> nameExtractor = p -> p.getName();
		out.println(nameExtractor.apply(new Person("Vaios", 18)));

		out.println();

		Predicate<Person> legalDrinkingAgeChecker = p -> p.getAge() >= 18;
		if (legalDrinkingAgeChecker.test(new Person("Mike", 15))) {
			out.println("Mike can drink");
		}else{
			out.println("Mike can't drink");
		}

		if (legalDrinkingAgeChecker.test(new Person("Ted", 22))) {
			out.println("Ted can drink");
		}

		out.println();

		List<Person> persons = Arrays.asList(new Person("Mike", 15), new Person("John", 18), new Person("takis", 20));

		persons.stream().filter(legalDrinkingAgeChecker).forEach(out::println);


		Consumer<String> printman = x -> out.println(x);
		printman.accept("test");

	}

}

class Person{

	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
