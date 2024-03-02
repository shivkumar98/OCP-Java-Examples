package revision_notes.chap09_v2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathObjectMethods {

	public static void main(String[] args) {
		Path currentDir = Paths.get("./");
		Path parentDir = Paths.get("./..");
//		System.out.println(Paths.get("./")); // .
//		System.out.println(Paths.get("./").getNameCount()); // 1
//		System.out.println(Paths.get("/./")); // /.
//		System.out.println(Paths.get("/./").getNameCount()); // 1
//		System.out.println(Paths.get("/./").getName(0)); // .
//	
		System.out.println("**********************");
		
		System.out.println(currentDir.toString()); // .
		System.out.println(currentDir.getFileName()); // .
		System.out.println(currentDir.getParent()); // null
		System.out.println(currentDir.getRoot()); // null
		
		System.out.println("-------------------");
		System.out.println(parentDir.toString()); // ./..
		System.out.println(parentDir.getNameCount()); // 2
		System.out.println(parentDir.getName(1)); // ..
		
		System.out.println("====================");
		
		// getParent gives the path of enclosing directory
		// returns null if there is no enclosing path
		// it will not look outside file system
		System.out.println("t: "+ Paths.get(".")
				.getParent()); // null
		
		System.out.println(Paths.get("src/path1/random").getParent());
		// src/path1
		
		System.out.println(Paths.get("src").getParent()); // null
		
		// getRoot finds the path element all the way to left
		// calling this on a relative path will always be null
		System.out.println(Paths.get("src/path1/random").getRoot());
		// null
		
		System.out.println(Paths.get("/home/zoo").getRoot()); // /
		
		System.out.println("++++++++++++++++++++");
		
		// isAbsolute checks if path is absolute
		
		// toAbsolutePath converts relative paths 
		// by appending to current dir
		
		System.out.println("current dir: "+Paths.get(".")
				.toAbsolutePath());
		// C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
		
		try {
			System.out.println("toRealPath: "+Paths.get(".").toRealPath());
			 // C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// if give an absolute path, it will append to the root dir
		System.out.println(Paths.get("/home/zoo")
				.toAbsolutePath()); // C:/home/zoo
		
		System.out.println("//////////////////////////");
		
		// the relativize method constructs a relative path
		// between two paths
		Path absolutePath = Paths.get("/home/zoo");
		Path absolutePath2 = Paths.get("/home/fish.txt");
		System.out.println(absolutePath.relativize(absolutePath2));
		// ../fish.txt		
		
		Path relativePath = Paths.get(".");
		Path relativePath2 = Paths.get("src/revision");
		System.out.println(relativePath.relativize(relativePath2));
		// src/revision
		
		// the relative paths must not go outside file system
		Path relativePath3 = Paths.get("home/../../home");
//		System.out.println(relativePath3.relativize(relativePath));
		// THROWS EXCEPTION
		
		// you can not match absolute with relative 
		// paths when using relativize
		
		System.out.println(".....................");
		
		// normalize removes redudancies from a path
		System.out.println(Paths.get("../../..").normalize());
		// ../../..
		
		// it has no awareness beyond the file system
		// does not check files actually exist
		
		System.out.println("\n======================\n");
		
		// toRealPath converts a path to a real one
		
		try {
			System.out.println(Paths.get(".").toRealPath());
			// C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// this method DOES support symbolic links
		

//		 System.out.println(Paths.get("/fake/madeup").toRealPath());
		// ^ throws exception

		
	}
}
