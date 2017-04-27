package eight;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class DefaultInterfaceMethods {

	public static void main(String[] args) {
		SomeWithDefaultMethod u = new Unimplemented();
		SomeWithDefaultMethod i = new Implemented();

		System.out.println(u.getSomeValue());
		System.out.println(i.getSomeValue());
	}

}

interface SomeWithDefaultMethod{
	default String getSomeValue(){
		return "default";
	}
}

class Unimplemented implements SomeWithDefaultMethod {

}

class Implemented implements SomeWithDefaultMethod {
	@Override
	public String getSomeValue() {
		return "I'm Different";
	}
}
