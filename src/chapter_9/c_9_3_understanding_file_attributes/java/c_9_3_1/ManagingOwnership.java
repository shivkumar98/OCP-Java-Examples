package chapter_9.c_9_3_understanding_file_attributes.java.c_9_3_1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class ManagingOwnership {
	// many file systmes support the idea of user owned files
	// and directories
	
	/* Method signatures:
	 * UserPrincipal getOwner(Path) throws IOException
	 * Path setOwner(Path, UserPrincipal) throws IOException
	 */
	
	// NIO.2 api provides a helper class for finding a UserPrincipal record:
	/* this is the UserPrincipalLookupService
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		try {
			UserPrincipalLookupService lookupService
				= FileSystems.getDefault().getUserPrincipalLookupService();
			UserPrincipal owner1 = lookupService
					.lookupPrincipalByName("Shiv");
			System.out.println(owner1); // DESKTOP-RSM8H8J\Shiv (User)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path file = Paths
				.get("src//"
					+ "chapter_9//"
					+ "c_9_3_understanding_file_attributes//"
					+ "java//"
					+ "c_9_3_1//"
					+ "hidden-file.txt");
		try {
			UserPrincipal owner = Files.getOwner(file);
			System.out.println(owner); // DESKTOP-RSM8H8J\Shiv (User)
			Files.setOwner(file, owner);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
