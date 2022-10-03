package chapter_1.chapter_1_6_enums;

public enum CombiningLogicAndState {
	
	/* since we have fields and constructors, we are able to program logic into enums*/

}


enum Seasons {
	WINTER {
		public void printHours() {
			System.out.println("9am-3pm");
		}
	}
,  SPRING{
	public void printHours() {
		System.out.println("10am-4pm");
	}
   }
,  SUMMER {
	public void printHours() {
		System.out.println("7am-8pm");
	}
   }
,  FALL {
	public void printHours() {
		System.out.println("7am-10pm");
	}
   }
}