package revision_notes.chap09_v2.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesAndViews {
	public static void main(String[] args) {
		// View is a group of related attributes for a
		// particular file system
		
		// view offers performance enhancements when reading multiple
		// attributes as less round trips are needed betwween
		// java and OS
		
		// There is an attribute class and view class
		// the attribute class offered a read-only view
		// the view class lets you modify attributes
		// I need to be aware of BasicFileAttributes
		// and BasicFileAttributeView
		
		// The Attribute class has multiple methods
		// analagous to the ones seen in Files
		
		// we use the following method to get the attribute class:
		// A Files.readAttributes(Path, Class<A>)
		// we shall use BasicFileAttributes class which is the only
		// class relevant to the exam but I need to know that
		// other classes exist to extract system dependent
		// attributes
		Path readMe = Paths.get("README.md");
		BasicFileAttributes attributes = null;
		try {
			attributes = Files.readAttributes(readMe, BasicFileAttributes.class);
		} catch (IOException e) { }
		
		// the BasicFileAttributes class has the following interfaces:
		System.out.println(attributes.lastModifiedTime()); 
		// 2024-02-27T09:58:35.534Z
		System.out.println(attributes.lastAccessTime());
		//  2024-02-27T15:20:01.2064654Z

		System.out.println(attributes.creationTime());
		// 2024-02-27T15:20:01.2064654Z

		System.out.println(attributes.isRegularFile());
		// true
		System.out.println(attributes.isSymbolicLink());
		// false
		System.out.println(attributes.isDirectory());
		// false
		System.out.println(attributes.isOther());
		// false
		System.out.println(attributes.size());
		// 1580
		System.out.println(attributes.fileKey()); // if file system uses keys
		// nulll
		
		// this class does NOT have a setter!!!!!!!
//		attributes.setTimes(); // COMPILER ERROR
		
		// in order to modify attributes we need to use views
		// the only view class I need to be aware of is BasicFileAttributeView
		
		BasicFileAttributeView view =
			Files.getFileAttributeView(readMe, BasicFileAttributeView.class);
		// you CAN obtain the attributes from the view:
		try {
			BasicFileAttributes attributesFromView =
				view.readAttributes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this specific view class has only one setter:
		FileTime newAccessedTime = FileTime.fromMillis(System.currentTimeMillis());
		try {
			view.setTimes(null, newAccessedTime, null);
			// ^ The arguments are lastModified, lastAccessed, creationTime
			// you use null if you do not want to modify it
		} catch (IOException e) { }

	}
}
