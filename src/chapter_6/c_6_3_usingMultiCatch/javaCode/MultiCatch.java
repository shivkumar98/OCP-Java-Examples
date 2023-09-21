package chapter_6.c_6_3_usingMultiCatch.javaCode;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MultiCatch {
	
	public static void main(String[] args) {
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException | IOException e) { // COMPILER ERROR
			
		}
	}

}
