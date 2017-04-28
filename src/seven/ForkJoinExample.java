package seven;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by zarkopafilis on 4/26/2017.
 */
public class ForkJoinExample {

	public static void main(String[] args){

		List<String> firstList = new ArrayList<>();

		for(int i = 0 ; i < 5000; i++) {
			firstList.add(i + "");
		}

		List<String> secondList = new ArrayList<>();

		for(int i = 0 ; i < 5000; i++) {
			secondList.add(i + "");
		}

		long start = System.currentTimeMillis();

		for (String s : firstList) {
			System.out.println(s);
		}

		for (String s : secondList) {
			System.out.println(s);
		}

		long single = System.currentTimeMillis() - start;

		start = System.currentTimeMillis();

		ForkJoinPool pool = ForkJoinPool.commonPool();
		SomeComputation firstSc = new SomeComputation(firstList);
		SomeComputation secondSc = new SomeComputation(secondList);

		pool.invoke(firstSc);
		pool.invoke(secondSc);

		long forkTime = System.currentTimeMillis() - start;

		System.out.println("Single Thread Time: " + single);
		System.out.println("Fork Join Time: " + forkTime);
	}


}

class SomeComputation extends RecursiveAction{

	private static int lengthTreshold = 100;
	List<String> n;

	public SomeComputation(List<String> n) {
		this.n = n;
	}


	@Override
	protected void compute() {
		if (n.size() < lengthTreshold) {
			computeDirectly();
		}else{
			System.out.println("-Splitting-");
			int middle = n.size() / 2;

			invokeAll(new SomeComputation(n.subList(0, middle)),
					new SomeComputation(n.subList(middle, n.size())));
		}
	}

	protected void computeDirectly() {
		for (String s : n) {
			System.out.println(s);
		}
	}

}
