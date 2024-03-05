package chapter_9.c_9_2_interacting_with_paths_files.java.c_9_2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingAndWritingFileDataUsingBufferedClasses {

	/*
	 * NIO.2 has ways of reading and writing file contents
	 * using java.io streams
	 * The Files class has a newBufferedReader method with signature:
	 * BufferedReader newBufferedReader(Path,Charset) throws IOException
	 * 
	 * There is also a newBufferedWriter with the following signature:
	 * BufferedWriter newBufferedWriter(Path,Charset) throws IOException
	 */
	
	public static void main(String[] args) {
		Path path = Paths.get("src//"
				+ "chapter_9//"
				+ "c_9_2_interacting_with_paths_files//"
				+ "javacode//"
				+ "file.txt");
		// this file has the following contents:
		/*  line 1
			line 2: Shiv is a cool guy
			line 3: hello world
		*/
		try (BufferedReader reader = Files
				.newBufferedReader(path, Charset.defaultCharset())) {
			// read from stream
			String currentLine = null;
			while((currentLine = reader.readLine())!=null) {
				System.out.println(currentLine); // prints each line of my file
			}
		} catch (IOException e) {
			System.out.println(e.getClass());
		}
		
		Path destinationFile = Paths
			.get("src//"
					+ "chapter_9//"
					+ "c_9_2_interacting_with_paths_files//"
					+ "javacode//"
					+ "destination-file.txt");
		try (BufferedWriter writer =
				Files.newBufferedWriter(destinationFile, Charset.defaultCharset())) {
			writer.write("Hello World!");
			// a new file is created with the above text!!!
		} catch (IOException e) {
			System.out.println(e.getCause());
		}
	}
}
