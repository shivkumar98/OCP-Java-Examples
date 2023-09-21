package chapter_6.c_6_3_usingMultiCatch.javaCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.management.RuntimeErrorException;

public class ConvertingException {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("dolphinBirthDate");
			String text = 
					new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(text);
			System.out.println(date);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e)  {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
