package seven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;


/**
 * Created by zarkopafilis on 4/26/2017.
 */
public class TryWithResources {

	public static void main(String[] args) {
		//Pre J7


		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("src/seven/file.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					//WOOPS - Destructive failure
				}
			}
		}

		out.println();
		out.println();
		out.println();
		//============================ After J7

		try (BufferedReader bufr = new BufferedReader(new FileReader("src/seven/file.txt"))){

			String line;

			while ((line = bufr.readLine()) != null) {
				out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
