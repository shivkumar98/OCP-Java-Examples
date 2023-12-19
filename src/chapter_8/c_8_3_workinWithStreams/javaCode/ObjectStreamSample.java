package chapter_8.c_8_3_workinWithStreams.javaCode;

import java.io.*;
import java.util.*;


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


public class ObjectStreamSample {
	static List<Animal> getAnimals(File dataFile) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<>();
		try (ObjectInputStream in = 
				new ObjectInputStream(
						
								new FileInputStream(dataFile))) {
			while(true) {
				Object object = in.readObject();
				if (object instanceof Animal)
					animals.add((Animal) object);
			}
		} catch (EOFException e) {
			// file end reached
		}
		return animals;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Monkey", 5, 'M'));
		animals.add(new Animal("Parrot", 2, 'B'));
		String animalFile = System.getProperty("user.dir")+"\\src"+
				"\\chapter_8\\c_8_3_workinWithStreams\\javaCode\\animal.data";
		File dataFile = new File(animalFile);
		createAnimalsFile(animals, dataFile);
		
		List<Animal> deserializedData = getAnimals(dataFile);
		System.out.println(deserializedData);
		// [Animal [name=Monkey, age=5, type=M], Animal [name=Parrot, age=2, type=B]]
	}

	static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(dataFile))) {
			for (Animal animal: animals) {
				out.writeObject(animal);
			}
		}
		
	}
}

