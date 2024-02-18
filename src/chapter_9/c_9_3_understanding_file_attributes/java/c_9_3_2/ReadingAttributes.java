package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class ReadingAttributes {
	
	public static void main(String[] args) throws IOException {
		Path file = Paths
			.get("src//"
				+ "chapter_9//"
				+ "README.md");
		BasicFileAttributes attributeData
			= Files.readAttributes(file, BasicFileAttributes.class);
		System.out.println("isDirectory: "+
			attributeData.isDirectory()); // false 
		System.out.println("isRegularFile: "+
			attributeData.isRegularFile()); // true
		System.out.println("isSymbolicLink: "+
			attributeData.isSymbolicLink()); // false
		// can be used to determine if file is a device or resource
		System.out.println("isOther: "+
			attributeData.isDirectory()); // true
		
		System.out.println("size: "+
			attributeData.size()); // 343
		
		FileTime creationTime = attributeData.creationTime();
		System.out.println("creationTime: " +
			attributeData.creationTime()); // 2024-01-06T08:42:35.6047179Z
		System.out.println("lastModifiedTime: " +
			attributeData.lastModifiedTime()); // 2024-01-06T08:46:37.0737933Z
		System.out.println("lastAccessTime: " +
			attributeData.lastAccessTime()); // 2024-02-10T11:35:04.9077723Z
		// unique identifier, null if not supported
		String fileKey = (String) attributeData.fileKey();
		System.out.println("fileKey (unique identifier): " +
			fileKey); // null
			
		
		
		
			
		
	}
}
