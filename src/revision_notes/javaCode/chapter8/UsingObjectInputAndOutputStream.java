package revision_notes.javaCode.chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class NotSerializable {
	String text = "hello";
}

public class UsingObjectInputAndOutputStream {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		String outputFileDestination = thisPackage+"\\serialized-output.txt";
		File outputFile = new File(outputFileDestination);
		System.out.println(outputFile.exists());
//		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(outputFile));
		// objectInputStream = new ObjectInputStream(new BufferedReader("")); // COMPILER ERROR
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
		objectOutputStream.writeObject("hello");
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(outputFile));
//		System.out.println(objectInputStream.read()); // -1
		System.out.println(objectInputStream.readObject()); // hello
		
		// objectOutputStream.writeObject(new NotSerializable()); // THROWS NotSerializableException
		
		
		
		objectOutputStream.writeObject("hi again");
		
		System.out.println(objectInputStream.readObject());
		}
}
