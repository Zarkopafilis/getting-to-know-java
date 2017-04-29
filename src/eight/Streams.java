package eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zarkopafilis on 4/28/2017.
 */
public class Streams {

	public static void main(String[] args) {

		Random r = new Random();
		String[] friendlyNames = {"Alpha", "Beta", "Delta", "George", "Takis"};

		List<Transaction> transactions = new ArrayList<>();
		for(int i=0;i<20;i++) {
			transactions.add(new Transaction(r.nextBoolean() ? TransactionType.BANK : TransactionType.PAYPAL,
					r.nextInt(500) + 500,
					friendlyNames[r.nextInt(friendlyNames.length)]));
		}

		transactions.stream().sorted((x,y) -> Integer.compare(x.getMoney(), y.getMoney()));

		transactions.stream().filter(x -> x.getTransactionType() == TransactionType.BANK).findFirst().ifPresent(System.out::println);


		long startTime = System.currentTimeMillis();
		System.out.println("Sum of transaction money: " + transactions.stream().mapToInt(x -> x.getMoney()).sum());
		System.out.println("Time: " + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		System.out.println("Sum of transaction money: " + transactions.parallelStream().mapToInt(x -> x.getMoney()).sum());
		System.out.println("Time: " + (System.currentTimeMillis() - startTime));
	}

}

enum TransactionType{
	BANK,PAYPAL
}

class Transaction{

	TransactionType transactionType;
	int money;
	String friendlyName;

	public Transaction(TransactionType transactionType, int money, String friendlyName) {
		this.transactionType = transactionType;
		this.money = money;
		this.friendlyName = friendlyName;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public int getMoney() {
		return money;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"transactionType=" + transactionType +
				", money=" + money +
				", friendlyName='" + friendlyName + '\'' +
				'}';
	}
}