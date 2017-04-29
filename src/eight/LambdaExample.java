package eight;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class LambdaExample {

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("One", "Two", "Three");

		proccess(listOfStrings, s -> System.out.println(s + "1"));
		proccess(listOfStrings, str -> System.out.println(str.toUpperCase()));

		IAmAFunctionalInterface func = s -> {
			if(s.equals("One")){
				System.out.println("1");
			}else{
				System.out.println(s);
			}
		};
		proccess(listOfStrings, func);


		Thread t = new Thread(() -> {

			System.out.println("Sleep");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Awake, bye");
		});

		t.start();

	}


	private static void proccess(List<String> entries, IAmAFunctionalInterface functionalInterface) {
		entries.forEach(functionalInterface::doStuff);
	}

}

interface IAmAFunctionalInterface {
	void doStuff(String s);
}
