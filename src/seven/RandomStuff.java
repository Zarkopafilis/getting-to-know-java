package seven;

/**
 * Created by zarkopafilis on 4/26/2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;


public class RandomStuff {

	public static void main(String[] args) {
		int a = 100_000;
		int b = 100000;

		out.println("a==b" + (a == b));

		String s = "a";

		switch(s){
			case "a":
				out.println("its a");
				break;
			case "b":
				out.println("its b");
				break;
			default:
				break;
		}

		//Diamonds
		List<String> oldList = new ArrayList<String>();
		List<String> newList = new ArrayList<>();

		out.println("\u6771" + " " + "\u00DF");


		for(int i = 0; i < 3;i++) {
			new Thread() {
				@Override
				public void run() {
					out.println(ThreadLocalRandom.current().nextInt());
				}
			}.start();
		}


	}

}
