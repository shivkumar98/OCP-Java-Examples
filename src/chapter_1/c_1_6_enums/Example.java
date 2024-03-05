package chapter_1.c_1_6_enums;
/*
 * An enum in java is a class which contains a fixed set of constants
 * Using enums prevents compilation errors
 * Conventionally, enum values are ALL CAPS
 * You can NOT extend an enum:
 *  enum MoreSeasons extends Season {
	 RANDOM
    } does not compile
 * 
 */
public class Example {
	public static void main(String[] args) {
		Season s = Season.SPRING;
		System.out.println(s); // SPRING
		
		// enum class has values() method which lets you loop through it:
		for (Season season: Season.values()){
			System.out.println(season.name()+ " "+season.ordinal());
		}
		
		// You can create an enum from a string:
		Season s1 = Season.valueOf("FALL");
		/* this throws runtime exception:
		Season s2 = Season.valueOf("fall");
		*/
	}

}
 enum Season {
	WINTER, SPRING, SUMMER, FALL
}

