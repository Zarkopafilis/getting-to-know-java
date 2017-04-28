package eight;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class LambdaExample {

	public static void main(String[] args) {

		List<String> stuff = Arrays.asList("One", "Two", "Three");

		proccess(stuff, x -> System.out.println(x + "1"));
		proccess(stuff, x -> System.out.println(x.toUpperCase()));

		IAmFunctional func = s -> {
			if(s.equals("One")){
				System.out.println("1");
			}else{
				System.out.println(s);
			}
		};
		proccess(stuff, func);


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


	private static void proccess(List<String> entries, IAmFunctional functionalInterface) {
		entries.forEach(functionalInterface::doStuff);
	}

}

interface IAmFunctional{
	void doStuff(String s);
}
