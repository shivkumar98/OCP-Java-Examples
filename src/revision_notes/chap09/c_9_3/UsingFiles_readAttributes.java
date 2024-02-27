package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class UsingFiles_readAttributes {
	
	public static void main(String[] args) {
		Path readMe = Paths.get("README.md");
		BasicFileAttributes attributes
			= null;
		try {
			attributes = Files.readAttributes(readMe, BasicFileAttributes.class);
		} catch (IOException e) { }

		System.out.println(attributes);
		System.out.println(attributes.isDirectory());
		System.out.println(attributes.isRegularFile());
		System.out.println(attributes.isSymbolicLink());
		System.out.println(attributes.isOther());
		System.out.println(attributes.size());
		System.out.println(attributes.creationTime());
		System.out.println(attributes.lastModifiedTime());
		System.out.println(attributes.lastAccessTime());
		System.out.println(attributes.fileKey());
//		attributes.setTimes(); does not compile
	}
	
}
