package review_questions.chapter_1.q01;

/* QUESTION: What is the result of the following code:
 * ANSWERS:
 *  A - Success
 *  B - Failure
 *  C - The hashCode() method fails to compile.
 *	D - The equals() method fails to compile.
 *	E - Another line of code fails to compile.
 * 	F - A runtime exception is thrown.
 * 
 * CORRECT ANSWER: A 
 */
public class Employee {
	public int employeeId;
	public String firstName, lastName;
	public int yearStarted;
	
	@Override
	public int hashCode() {
		return employeeId;
	}
	
	public boolean equals(Employee e) {
		return this.employeeId == e.employeeId;
	}
	public static void main(String[] args) {
		Employee one = new Employee();
		one.employeeId = 101;
		Employee two = new Employee();
		two.employeeId = 101;
		if (one.equals(one))
			System.out.println("Success");
		else System.out.println("Failure");
	}
}
