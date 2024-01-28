package revision_notes.javaCode.chapter4;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	int id;
	String name;
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
	
	
	
}

public class CollectingIntoMaps {
	
	public static void main(String[] args) {
		Stream<Employee> employees
		= Stream.of(new Employee(1, "Shiv"),
				new Employee(2,"Kumar"));
	
	Function<Employee, Employee> valueMapper = e->e;
	Map<Integer, Employee> map
		= employees.collect(Collectors.toMap(e->e.id,valueMapper));

	System.out.println(map); // {1=[id=1, name=Shiv], 2=[id=2, name=Kumar]}

	}


	
}
