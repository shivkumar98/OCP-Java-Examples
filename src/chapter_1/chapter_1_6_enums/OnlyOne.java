package chapter_1.chapter_1_6_enums;

public enum OnlyOne {
  ONCE(true);
  private OnlyOne(boolean b) { // code cannot compile with public constructor since it can only be called from within enum
	  System.out.println("constructing");
  }
  
  public static void main(String[] args) {
	OnlyOne once = OnlyOne.ONCE; // prints: "constructing"
	OnlyOne twice = OnlyOne.ONCE; // prints nothing
  }
}
