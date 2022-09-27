package chapter_1.chapter_1_6.enums;

public class SwitchExample {
	public static void main(String[] args) {
		Season summer = Season.SUMMER;
		switch(summer) {
			case WINTER:{
				System.out.println("Winter has came");break;
			}
			case FALL: {
				System.out.println("Winter is coming"); break;
			}
			/* you cannot referenc enum name:
			case Season.SPRING: {
				
			}
			enum type is implied
			*/
			default:{
				System.out.println("winter is coming.. probably");
			}
		}
		
	
	}

}
