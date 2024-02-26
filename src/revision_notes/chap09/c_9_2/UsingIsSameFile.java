package revision_notes.chap09.c_9_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingIsSameFile {
	// isSameFile will throw an exception if files do not exist
	// this will first check if the files are the same
	// in terms of equals
	
	// this method can return true even if file does not exist
	
	public static void main(String[] args) {
		Path realRelPath = Paths.get("src");
		Path realAbsPath = Paths.get("C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/src");
		Path realRelPath2 = Paths.get("src/chapter_9");
		try {
		System.out.println(Files.isSameFile(realRelPath, realRelPath2));
			// false
		System.out.println(Files.isSameFile(realRelPath, realAbsPath));
			// true
		System.out.println("equals(): "+ realRelPath.equals(realAbsPath));
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		Path fakeRelPath = Paths.get("src/fake");
		Path fakeAbsPath = Paths.get("/home/zoo/");
		Path fakeRelPath2 = Paths.get("src/fake/");
		try {
			System.out.println(Files.isSameFile(realRelPath, fakeRelPath));
		} catch (IOException e) {
			System.out.println("exception 0");			
		} // exception thrown
		
		try {
			System.out.println(Files.isSameFile(fakeRelPath, fakeAbsPath));
		} catch (IOException e) {
			System.out.println("exception 1");
		}
		
		try {
			System.out.println(Files.isSameFile(fakeRelPath, fakeRelPath2));
			// true
		} catch (IOException e) {
			System.out.println("exception 2");
		}
		try {
			Path fakeAbsolutePath = Paths.get("/home/zoo");
			Path fakeAbsolutePath2 = Paths.get("/home/zoo/");
			System.out.println(fakeAbsolutePath.equals(fakeAbsolutePath2));
			System.out.println(
				Files.isSameFile(fakeAbsolutePath, fakeAbsolutePath2)
			);
		} catch (IOException e) {
			System.out.println("exception 3");
		}
		
		System.out.println("_-=---------=---==-0-___");
		try {
			Path path1 = Paths.get("/home/zoo/../zoo");
			Path path2 = Paths.get("/home/zoo");
			System.out.println(
				path1.equals(path2));
			// false
			System.out.println(
				path1.normalize().equals(path2.normalize())
			);
			// true
			Files.isSameFile(path1, path2); // THROWS EXCEPTION
		} catch (IOException e) {
			System.out.println("exception 4");
		}
	}
	

}
