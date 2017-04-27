package seven;

import static java.lang.System.out;
import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

/**
 * Created by zarkopafilis on 4/26/2017.
 */
public class IOExamples {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		for (Path p : FileSystems.getDefault().getRootDirectories()) {
			out.println(p);
		}



//		Files.createSymbolicLink(Paths.get("C:\\Users\\zarkopafilis\\Desktop\\GettingToKnowJava\\tests"), Paths.get("C:\\Users\\zarkopafilis\\Desktop\\GettingToKnowJava"));

		//Watch service
		Path targetDir = Paths.get("C:\\Users\\zarkopafilis\\Desktop\\GettingToKnowJava\\tests");
		WatchService watcherSvc = FileSystems.getDefault().newWatchService();
		WatchKey watchKey = targetDir.register(watcherSvc, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

		while (true) {
			watchKey=watcherSvc.take();
			for (WatchEvent<?> event: watchKey.pollEvents()) {
				WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
				System.out.println(event.kind().name() + " " + event.context());
				watchKey.reset();
			}
		}
	}

}
