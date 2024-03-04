package revision_notes.chap09.java;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PathFileMethods {
	public static void main(String[] args) {
		// The Files class is a helper class
		// to help deal with Paths representing files
		
		// Files.exists() checks if the file/dir exists
		
		System.out.println(
			Files.exists(Paths.get("fake/madeup"))
		); // false
		
		System.out.println(
			Files.exists(Paths.get("src"))
		); // true
		
		System.out.println("\n--------------------\n");
		
		// Files.isSameFile checks that two paths point to the same file
		// if we had two files with the same content
		// and metadata, this method would still return false
		// if the files had different locations
		// This method throws a checked exceptioni if 
		// either file does not exist
		
		try {
			System.out.println(
				Files.isSameFile(
					Paths.get("src"), 
					Paths.get("C:/Users/Shiv/Documents/GitHub/OCP-Java-Examples/src"))
			);
			// TRUE
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// This method can still return true even if the 
		// paths do not exist, this is provided the paths
		// are same in terms of equals()
		
		Path path = Paths.get("fake/madeup");
		Path path2 = Paths.get("fake/madeup/");
		System.out.println(path.equals(path2));
		// TRUE
		try {
			System.out.println(
				Files.isSameFile(
					path, 
					path2
				)
			);
			// TRUE
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("\n***************\n");
		
		Path newFolder = Paths
			.get("src/revision_notes/chap09_v2/new_folder");
		try {
			Path createdDir = Files.createDirectory(newFolder);
			System.out.println(createdDir); // src\revision_notes\chap09_v2\new_folder
		} catch (IOException e) {
			System.out.println("folder already exists");
		}
		
		System.out.println("\n-------------------------\n");
		Path source = newFolder;
		Path target = Paths.get("src/revision_notes/chap09_v2/newfolderV2");
		try {
			Path copied = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(copied);
			// src/revision_notes/chap09_v2/newfolderv2
		} catch (IOException e) {
	
		}
		
		// by default symbolic links are traversed,
		// will not overwrite existing,
		// and will not copy attributes
		
		System.out.println("\n---------------------\n");
		
		// Files.move is like file.renameTo()
		// it will not overwrite existing files, 
		// meta data IS copied over
		
		Path a = Paths
			.get("src/revision_notes/chap09_v2/newfolderV2");
		Path b = Paths
				.get("src/revision_notes/chap09_v2/newfolderV3");
		try {
			Path moved = Files.move(a,b,StandardCopyOption.REPLACE_EXISTING);
			System.out.println(moved);
			// src\revision_notes\chap09_v2\newfolderV3
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n......................\n");
		
		Path folderToBeDeleted = Paths
				.get("src/revision_notes/chap09_v2/newfolderV3");
		try {
			boolean isDeleted = Files.deleteIfExists(folderToBeDeleted);
			System.out.println(isDeleted); // true
			// Files.delete() is void return
		} catch (IOException e) {
			
		}
		
		System.out.println("\n++++++++++++++++++++++++\n");
		
		Path textFile = Paths
				.get("src/revision_notes/chap09_v2/file.txt");
		try {
			List<String> list = Files.readAllLines(textFile);
			System.out.println(list);
			// [line 1 , line 2]

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	
}
