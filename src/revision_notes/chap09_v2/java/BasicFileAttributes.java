package revision_notes.chap09_v2.java;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class BasicFileAttributes {
	
	public static void main(String[] args) {
		// the Files class has 3 helper methods for finding basic 
		// file attributes that all file systems will have
		// 1. Files.isDirectory()
		// 2. Files.isSymbolicLink()
		// 3. Files.isRegularFile()
		
		// a regular file is defined as something which is not either
		// of: directory, symbolic link, resource
		
		// typically only one of these methods returns true
		// however a symbolic link pointing to a regular file
		// in the file system will have isRegularFile() be true
		// and vice versa
		Path regularFile = Paths.get("README.md");
		System.out.println(Files.isRegularFile(regularFile));
		// true
		System.out.println(Files.isDirectory(regularFile));
		// false
		System.out.println(Files.isSymbolicLink(regularFile));
		// false
		
		// Files.isHidden checks if a file is hidden or not
		// this method DOES throw a checked exception
		Path nonHiddenFile = Paths.get("README.md");
		try {
			System.out.println(Files.isHidden(nonHiddenFile));
			// false
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Files.size() returns size
		try {
			System.out.println(Files.size(regularFile));
			// 1580
		} catch (IOException e) {
			
		}
		
		// UserPrincipal getOwener(Path)
		// Path setOwner(Path,UserPrincipal)
		
		try {
			System.out.println(
				Files.getOwner(regularFile)
					);
			// DESKTOP-RSM8H8J\Shiv (User)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserPrincipalLookupService lookup
			= FileSystems
				.getDefault()
				.getUserPrincipalLookupService();
		try {
			UserPrincipal user = lookup.lookupPrincipalByName("Shiv");
			// ^ can be used to set owner
			System.out.println("user: "+user);
			// user: DESKTOP-RSM8H8J\Shiv (User)
		} catch (IOException e) {
		}
		
		// You can set the FileTime lastModifiedTime
		try {
			FileTime dateTime = 
			Files.getLastModifiedTime(regularFile);
			System.out.println(dateTime);
			// 2024-02-10T10:58:40.7507014Z
			Path p = Files.setLastModifiedTime(regularFile, dateTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// filetime can be converted to epoch (milliseconds) length
		FileTime dateTime = FileTime.fromMillis(System.currentTimeMillis());
		dateTime.toMillis(); 
	}

}
