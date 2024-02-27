package revision_notes.chap09.c_9_3;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class UsingFiles_getAttibuteView {
	
	public static void main(String[] args) {
		// the below view has setTimes() method
		BasicFileAttributeView view = null;
		BasicFileAttributes attributes = null;
		try {
			attributes = view.readAttributes();
		} catch (IOException e) { }
		try {
			
			view.setTimes(null, null, null);
			// sets lastModified, last access, and creationTime
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
