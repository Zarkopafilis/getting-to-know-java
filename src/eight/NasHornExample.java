package eight;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Created by zarkopafilis on 4/27/2017.
 */
public class NasHornExample {
	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		//JAVA_HOME/bin/jjs

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World!');");

		engine.eval(new FileReader("src/eight/nashorn.js"));

		Invocable invocable = (Invocable) engine;

		try {
			String result = (String) invocable.invokeFunction("func1", "Peter Parker");
			System.out.println(result);
			System.out.println(result.getClass());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public static String func2(String data) {
		return data.toUpperCase();
	}

	public static void mirrors(ScriptObjectMirror mirror) {
		System.out.println(mirror.getClassName() + ": " +
				Arrays.toString(mirror.getOwnKeys(true)));
	}


	public static void callJs(ScriptObjectMirror person) {
		System.out.println("Full Name is: " + person.callMember("getFullName"));
	}

}
