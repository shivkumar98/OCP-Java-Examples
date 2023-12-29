package revision_notes.javaCode.chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HighLevelStreams {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String srcLocation = System.getProperty("user.dir")+"\\src";
		String thisPackage = srcLocation+"\\revision_notes\\javaCode\\chapter8";
		FileReader fileInputReader = new FileReader(thisPackage+"\\alphabet.txt");
		String alphabetFile = thisPackage+"\\alphabet.txt";
		//FileInputStream fileInputStream = new FileInputStream(null);
		System.out.println( (char)fileInputReader.read()); // a
		// BufferedReader buffReader = new BufferedReader(new File("s")); // COMPILER ERROR
		BufferedReader bufferedReader = new BufferedReader(fileInputReader);
		System.out.println(bufferedReader.readLine()); // bcd
		// COMPILER ERROR BELOW:
		// bufferedReader = new BufferedReader(new InputStreamReader(fileInputReader));
		ObjectOutputStream objectOutputStream =
			new ObjectOutputStream(
				new FileOutputStream(
					new File(thisPackage+"\\output.log")));
		objectOutputStream.writeObject("hello world!");
		
		ObjectInputStream objectInputStream = 
				new ObjectInputStream(
					new FileInputStream(
						new File(thisPackage+"\\output.log")));
		System.out.println(objectInputStream.readObject()); // hello world
		objectInputStream =
				new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream(
							new File(thisPackage+"\\output.log"))));
		
	}
}
