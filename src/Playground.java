import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zarkopafilis on 4/29/2017.
 */
public class Playground {

	int a;
	int b;
	String c;

	public Playground(int a, String c) {
		this.a = a;
		this.c = c;
	}

	public Playground(int a, int b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public String getC() {
		return c;
	}

	@Override
	public String toString() {
		return "Playground{" +
				"a=" + a +
				", b=" + b +
				", c='" + c + '\'' +
				'}';
	}

	public static void main(String[] args) {

	}



}
