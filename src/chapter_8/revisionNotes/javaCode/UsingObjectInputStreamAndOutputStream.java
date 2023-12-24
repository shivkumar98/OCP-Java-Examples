package chapter_8.revisionNotes.javaCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private char type;
	public Animal(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}
	public String getName() { return name; }
	public int getAge() { return age; }
	public char getType() { return type; }
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
	}
}

public class UsingObjectInputStreamAndOutputStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String location = System.getProperty("user.dir")+"\\src"+"\\chapter_8"
				+"\\revisionNotes\\javaCode\\Animals-data.log";
		List<Animal> animals = Arrays.asList(new Animal("Tiger",1,'m'),
				new Animal("parrot",2,'b'));
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(location));
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(location))) {
			for (Animal animal: animals)
				objectOutputStream.writeObject(animal);
			System.out.println(objectInputStream.readObject()); // Animal [name=Tiger, age=1, type=m]
			System.out.println(objectInputStream.readObject()); // Animal [name=parrot, age=2, type=b]
			System.out.println(objectInputStream.readObject()); // throws EOF Exception

		}
		
	}
}
