package revision_notes.chap09.c_9_2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingIsAbsoluteAndToAbsolutePath {
	public static void main(String[] args) {
		
		Path relPath = Paths.get("src/chapter_9");
		System.out.println(relPath.toAbsolutePath());
		// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\src\chapter_9
		System.out.println(relPath.isAbsolute());
		// false
		
		System.out.println("===========1===============");
		

		// if a non-existent relative path is provided,
		// then the rel path is appended to the current directory
		Path fakeRelPath = Paths.get("fake/madeup");
		System.out.println(fakeRelPath.toAbsolutePath());
		// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\fake\madeup
		System.out.println(fakeRelPath.isAbsolute());
		// false
		
		System.out.println("==========2===============");
		
		Path absPath = Paths.get("C:/Users/Shiv/Documents/"
				+ "GitHub/OCP-Java-Examples/src/"
				+ "chapter_9");
		System.out.println(absPath.toAbsolutePath());
		// C:\Users\Shiv\Documents\GitHub\OCP-Java-Examples\src\chapter_9
		System.out.println(absPath.isAbsolute());
		// true
		
		System.out.println("==========3===========");
		
		Path fakeAbsPath = Paths.get("C:\\Users\\home\\zoo");
		System.out.println(fakeAbsPath.toAbsolutePath());
		// C:\Users\home\zoo
		System.out.println(fakeAbsPath.isAbsolute());
		// true
	}
}
