package chapter_1.revision_notes;

public enum Seasons {
	WINTER {void printHours() {
		System.out.println("11am-4pm");
		}
	},
	SPRING {void printHours() {
		System.out.println("9am-6pm");
	}},
	SUMMER {
		void printHours() {} 
	};
	abstract void printHours();
}
