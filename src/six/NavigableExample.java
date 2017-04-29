package six;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.lang.System.out;

/**
 * Created by zarkopafilis on 4/26/2017.
 */
public class NavigableExample {

	public static void main(String[] args) {
		NavigableSet<Integer> original = new TreeSet<>();

		original.add(1);
		original.add(2);
		original.add(3);
		original.add(4);
		original.add(5);
		original.add(6);

		for (Integer i : original) {
			out.println(i);
		}

		out.println();

		for (Integer i : original.descendingSet()) {
			out.println(i);
		}

		//values less than 3
		SortedSet<Integer> sort = original.headSet(3);

		out.println();

		for (Integer i : sort) {
			out.println(i);
		}

		//"inclusive"=true
		NavigableSet<Integer> head = original.headSet(3, true);

		out.println();

		for (Integer i : head) {
			out.println(i);
		}

		out.println();

		out.println("Poll first: " + original.pollFirst() + " poll last: " + original.pollLast());

		out.println("Ceiling(4): " + original.ceiling(4) + " Floor(2): " + original.floor(2));

		out.println("Higher(3): " + original.higher(3) + " lower(3): " + original.lower(3));


	}

}
