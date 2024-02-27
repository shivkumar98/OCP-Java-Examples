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
		
		attributes.isDirectory();
		attributes.isRegularFile();
		attributes.isSymbolicLink();
		attributes.isOther();
		long size = attributes.size();
		FileTime creationTime = attributes.creationTime();
		FileTime lastModifiedTime = attributes.lastModifiedTime();
		FileTime lastAccessTime = attributes.lastAccessTime();
		Object fileKey = attributes.fileKey();
//		attributes.setTimes(); does not compile
	}
	
}
