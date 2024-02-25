package revision_notes.chap09.c_9_2;

import java.nio.file.Paths;

public class UsingNormalize {

	// normalize eliminates redudancies of a path
	// this method does not check if it actually exists
	// if a relative path is provided, a relative path is returned
	
	
	public static void main(String[] args) {
		System.out.println(
			Paths.get("home/../../..").normalize()
		);
		// ../..
		System.out.println(
			Paths.get("/home/../../..").normalize()
		);
		// /
		System.out.println(
			Paths.get("/home/../home/").normalize()
		);
		// /home
		System.out.println("rel: " +
				Paths.get("home/..").normalize()
			);
			// BLANK
		
	}
}
