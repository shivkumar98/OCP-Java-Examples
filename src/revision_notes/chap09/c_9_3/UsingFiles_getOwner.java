package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class UsingFiles_getOwner {
	
	public static void main(String[] args) {
		Path path = Paths.get("README.md");
		
		try {
			UserPrincipal owner = Files.getOwner(path);
			System.out.println(owner); // shiv.kumar (User)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserPrincipalLookupService lookupService
			= FileSystems.getDefault().getUserPrincipalLookupService();
		try {
			UserPrincipal lookedUp = 
			lookupService.lookupPrincipalByName("shiv.kumar (User)");
			System.out.println(lookedUp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
