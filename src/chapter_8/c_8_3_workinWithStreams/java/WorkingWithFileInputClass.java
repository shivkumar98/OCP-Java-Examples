package chapter_8.c_8_3_workinWithStreams.java;
import java.io.*;

public class WorkingWithFileInputClass {
	public static void main(String[] args) throws IOException {
		String location = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\data.txt";
		File file = new File(location);
		FileInputStream ir = new FileInputStream(location);

		try (InputStream in = new FileInputStream(location)) {

			int b;
			while((b=in.read())!=-1) {
				System.out.println((char)b);
			}

		}
	}
}
