package seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class AnotherForkJoinExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		for(int i = 0 ; i < 500000; i++) {
			list.add(i);
		}

		ForkJoinPool pool = ForkJoinPool.commonPool();
		SomeOtherComputation firstSc = new SomeOtherComputation(list);

		int res = pool.invoke(firstSc);
		System.out.println("Result: " + res);
	}
}

class SomeOtherComputation extends RecursiveTask<Integer> {

	private static int lengthTreshold = 100;
	List<Integer> n;

	public SomeOtherComputation(List<Integer> n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		if (n.size() < lengthTreshold) {
			return computeDirectly();
		}else{
			int middle = n.size() / 2;

			SomeOtherComputation one = new SomeOtherComputation(n.subList(0, middle));
			SomeOtherComputation two = new SomeOtherComputation(n.subList(middle, n.size()));

			one.fork();

			int twoRes = two.compute();
			int oneRes = one.join();

			return oneRes + twoRes;
		}
	}

	protected int computeDirectly() {
		return n.stream().mapToInt(x -> x).sum();
	}

}
