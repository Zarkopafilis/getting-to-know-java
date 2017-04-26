package six;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.System.out;


/**
 * Created by zarkopafilis on 4/26/2017.
 */

//Double Ended QUEUE
public class DequeueExample {

	public static void main(String[] args){

		Deque<String> deq = new ArrayDeque<>();
		deq.add("A");
		deq.add("B");
		deq.add("C");

		out.println("First: " + deq.peekFirst());
		out.println("Last: " + deq.peekLast());

		out.println();

		for (String s : deq) {
			out.println(s);
		}

		deq.removeLast();

		out.println();

		for (String s : deq) {
			out.println(s);
		}

		deq.removeFirst();

		out.println();

		for (String s : deq) {
			out.println(s);
		}

		deq.addFirst("New A");
		deq.addFirst("New C");

		out.println();

		for (String s : deq) {
			out.println(s);
		}

	}

}
