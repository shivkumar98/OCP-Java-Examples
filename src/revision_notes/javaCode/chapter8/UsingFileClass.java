package revision_notes.javaCode.chapter8;

import java.io.File;

public class UsingFileClass {
	public static void main(String[] args) {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes";
		File file = new File(thisPackage+"\\data.txt");
		System.out.println(file.exists());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getName()); // data.txt
		file.delete();
		file.renameTo(new File(""));
		File fileWithNoParentDirectory = new File(thisPackage+"\\data2.txt");
		System.out.println(fileWithNoParentDirectory.mkdir()); // true
		File fileWithNonExistentParent = new File(thisPackage+"\\hello\\data2.txt");
		System.out.println(fileWithNonExistentParent.mkdir()); // false
		System.out.println(fileWithNonExistentParent.mkdirs()); // true
		System.out.println(fileWithNonExistentParent.getParent());
		fileWithNonExistentParent.listFiles();
		file.lastModified();
	}
}
