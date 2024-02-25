package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingToRealPath {
	public static void main(String[] args) {
		// to real path takes a path and converts
		// it to an absolute path within the file system
		
		Path nonExistentAbsPath = Paths.get("/home/zoo");
		
		try {
			System.out.println("real: "+
				nonExistentAbsPath.toRealPath()
			); 
		} catch (IOException e) {
			System.out.println("exception");
		} // exception thrown
		
		Path existentRelPath = Paths.get("src/chapter_9");
		try {
			System.out.println("real: "+
				existentRelPath.toRealPath()
			); 
			// real: C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
			// /src/chapter_9
		} catch (IOException e) {
			System.out.println("exception");
		}
		
		Path nonExistentRelPath = Paths.get("fake");
		try {
			System.out.println("real: "+
				nonExistentRelPath.toRealPath()
			); 
		} catch (IOException e) {
			System.out.println("exception");
		} // exception thrown
		
		Path relOutsideFileSystem = Paths.get("./..");
		try {
			System.out.println("real: 1 "+
				relOutsideFileSystem.toRealPath()
			); 
			// real: C:/Users/Shiv/Documents/GitHub
		} catch (IOException e) {
			System.out.println("exception");
		}
		
		// we can get the current working directory:
		Path currentDir = Paths.get(".");
		try {
			System.out.println("real: 1 "+
				currentDir.toRealPath()
			); 
			// real: C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
		} catch (IOException e) {
			System.out.println("exception");
		}
	}
}
