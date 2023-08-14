package chapter_1.chapter_1_6_enums;

public class EnumExample {
	public static void main(String[] args) {
		SeasonV3 s = SeasonV3.SUMMER;
		
	}
}

enum SeasonV2
{
   WINTER("low"), 
   AUTUMN("medium"), 
   SPRING("high"), 
   SUMMER("max");

   private String pattern;

   SeasonV2(String pattern) {
       this.pattern = pattern;
   }
   
   String getValue() {
	   return pattern;
   }

   
}

enum SeasonV3 {
	
WINTER {
public void printHours() { System.out.println("short hours"); }
}, SUMMER {
public void printHours() { System.out.println("long hours"); }
};
public abstract void printHours();
}