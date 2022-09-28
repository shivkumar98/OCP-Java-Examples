package review_questions.chapter_1.q04;
/* QUESTION: What is true about the following code? You may assume city and mascot are never nulL.*/
/* OPTIONS:
A. The class does not compile.
B. The class compiles but has an improper equals() method.
C. The class compiles but has an improper hashCode() method.
D. The class compiles and has proper equals() and hashCode() methods.

CORRECT ANSWER: C - the hashCode method violates the rule that two instances which are equal have the same hashCode
 */
public class BaseballTeam {
	private String city, mascot;
	private int numberOfPlayers;
	public boolean equals(Object obj) {
		if (!(obj instanceof BaseballTeam))
			return false;
		BaseballTeam other = (BaseballTeam) obj;
		return (city.equals(other.city) && mascot.equals(other.mascot));
	}
	public int hashCode() {
		return numberOfPlayers;
	}
	
	public static void main(String[] args) {
		BaseballTeam one = new BaseballTeam();
		one.numberOfPlayers = 23;
		one.city = "Birmingham";
		one.mascot = "Bull";
		BaseballTeam two = new BaseballTeam();
		two.numberOfPlayers = 4689;
		two.city = "Birmingham";
		two.mascot = "Bull";
		System.out.println(one.equals(two)); // true
		System.out.println(one.hashCode() + " "+ two.hashCode()); // 23 4689
		// hashcods should not differ! :(
	}
}
