package revision_notes.chap09.c_9_1;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;

public class UsingPaths {
	public static void main(String[] args) {
		System.out.println(Paths.get("src/chapter_9")
				.toAbsolutePath());
		Path absolutePath = 
			Paths.get("C:\\Users\\Shiv\\Documents\\"
					+ "GitHub\\OCP-Java-Examples\\"
					+ "src\\chapter_9");
		System.out.println(absolutePath);
		URI uri = null;
		try {
		uri = new URI("hello");
		} catch (URISyntaxException e) {
			// TODO: handle exception
		}
		Path uriPath = Paths.get(uri);
	}
}
